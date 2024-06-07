DROP PROCEDURE IF EXISTS `CREATE_EXAM_INSTANCE`;

CREATE PROCEDURE `CREATE_EXAM_INSTANCE`(

    IN  p_exam_id     INT,

    IN  p_profile_id  INT,

    IN  p_creator     VARCHAR(255),

    OUT o_rowcount    INT

)
BEGIN

	-- declare begin

 	DECLARE v_done              INT DEFAULT FALSE;

 	DECLARE v_category          INT DEFAULT(0);

	DECLARE v_level             INT DEFAULT(0);

	DECLARE v_num               INT DEFAULT(0);

	DECLARE v_question_id       INT DEFAULT(0);

	DECLARE v_question_exam_id  INT DEFAULT(0);

	DECLARE v_rowcount          INT DEFAULT(0);



	DECLARE cs CURSOR FOR

	 	with recursive qn AS

 			(select 1 as num union distinct select 1+num from qn WHERE num < 100)

SELECT T1.CATEGORY_ID

     , T1.`LEVEL`

     , qn.num

FROM tb_excan_setting_item T1

         INNER JOIN  qn

                     ON T1.NUMBER_OF_QUESTION >= qn.num

WHERE T1.setting_id = p_profile_id

ORDER BY T1.id, qn.num ;



DECLARE

CONTINUE HANDLER FOR NOT FOUND

		SET v_done = TRUE;

	-- declare end



	-- delete exam instance if exist

DELETE FROM tb_excan_exam_question WHERE exam_id = p_exam_id;



-- loop for temporary list of question (in memory)

OPEN cs;

aloop: LOOP

	   FETCH cs INTO v_category, v_level, v_num;



	   -- exit when finish last row

		IF v_done THEN

			LEAVE aloop;

END IF;



		-- insert an exam_question

INSERT INTO tb_excan_exam_question

(question_id

, exam_id

, create_at

, create_by)

SELECT

    T1.id

     , p_exam_id

     , SYSDATE()

     , p_creator

FROM tb_excan_question T1

WHERE T1.CATEGORY_ID = v_category

  AND T1.`LEVEL` = v_level

  AND NOT EXISTS (

    -- do not allow duplicate question

    SELECT 1

    FROM tb_excan_exam_question

    WHERE exam_id = p_exam_id

      AND question_id = T1.ID

)

ORDER BY RAND() LIMIT 1;

SELECT LAST_INSERT_ID() INTO v_question_exam_id;

SELECT ROW_COUNT() INTO v_rowcount;



-- write a random answer order

IF v_rowcount > 0 THEN

SELECT question_id INTO v_question_id FROM tb_excan_exam_question WHERE ID = v_question_exam_id;



UPDATE tb_excan_exam_question

SET ANSWER_ORDER = (

    select

        group_concat(ID ORDER BY RAND() separator ',')

    FROM tb_excan_answer

    WHERE question_id = v_question_id and answer_order > 0

)

WHERE ID = v_question_exam_id;



END IF;



END LOOP aloop;



CLOSE cs;



SET o_rowcount = v_rowcount;



END