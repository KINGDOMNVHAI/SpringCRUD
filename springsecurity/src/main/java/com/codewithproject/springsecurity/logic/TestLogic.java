package com.codewithproject.springsecurity.logic;

import com.codewithproject.springsecurity.entities.Test;
import com.codewithproject.springsecurity.repository.TestRepository;
import com.codewithproject.springsecurity.store.TestStore;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
 * Logic package: call repository or create CriteriaBuilder
 * */
@Service
public class TestLogic {

    @Autowired
    private TestStore store;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TestRepository testRepo;

    public long getBrandCount() {
        return testRepo.count();
    }

//    public List<Test> getListBrand() {
//        return testRepo.getListBrand();
//    }

    public Optional<Test> getBrandByCode(String urlTest) {
        return testRepo.getTestByURL(urlTest);
    }

//    public TypedQuery<BrandDto> retrieveFindTest(String urlTest) {
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<BrandDto> brandEntityQuery = builder.createQuery(BrandDto.class);
//        Root<Brand> brandRoot = brandEntityQuery.from(Brand.class);
//
//        // build all the selected column
//        CompoundSelection<BrandDto> compoundSelection = builder.construct(BrandDto.class,
//                brandRoot.get("brandCD").alias("brandCD")
//        );
//        brandEntityQuery.select(compoundSelection);
//        brandEntityQuery.distinct(true);
//
//        List<Predicate> listPredicates = store.buildPredicateCheckParent(builder, brandRoot, brandCD);
//        brandEntityQuery.where(listPredicates.toArray(new Predicate[0]));
//
//        return entityManager.createQuery(brandEntityQuery);
////        queryCustom.setMaxResults(10000);
//    }
}
