package com.codewithproject.springsecurity.logic;

import com.codewithproject.springsecurity.dto.entitydto.ChannelDto;
import com.codewithproject.springsecurity.dto.logic.ChannelVideoLogicStore;
import com.codewithproject.springsecurity.entities.Channel;
import com.codewithproject.springsecurity.repository.ChannelRepository;
import com.codewithproject.springsecurity.store.ChannelStore;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CompoundSelection;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Logic package: call repository or create CriteriaBuilder
 * */
@Service
public class ChannelLogic {

    @Autowired
    private ChannelStore store;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ChannelRepository channelRepo;

    public long getBladeCount() {
        return channelRepo.count();
    }

    public TypedQuery<ChannelDto> retrieveListChannel(ChannelVideoLogicStore req) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ChannelDto> bladeEntityQuery = builder.createQuery(ChannelDto.class);
        Root<Channel> channelRoot = bladeEntityQuery.from(Channel.class);

        // build all the selected column
        CompoundSelection<ChannelDto> compoundSelection = builder.construct(ChannelDto.class,
            channelRoot.get("idChannel").alias("idChannel"),
            channelRoot.get("nameChannel").alias("nameChannel"),
            channelRoot.get("urlChannel").alias("urlChannel"),
            channelRoot.get("urlVideoPresent").alias("urlVideoPresent"),
            channelRoot.get("descriptionChannel").alias("descriptionChannel"),
            channelRoot.get("createdDateChannel").alias("createdDateChannel"),
            channelRoot.get("subscribe").alias("subscribe"),
            channelRoot.get("thumbnailChannel").alias("thumbnailChannel"),
            channelRoot.get("subscribe").alias("subscribe"),
            channelRoot.get("websiteChannel").alias("websiteChannel"),
            channelRoot.get("facebookChannel").alias("facebookChannel"),
            channelRoot.get("twitterChannel").alias("twitterChannel")
        );
        bladeEntityQuery.select(compoundSelection);
        bladeEntityQuery.distinct(true);

        List<Predicate> listPredicates = store.buildPredicateListChannel(builder, channelRoot, req);
        bladeEntityQuery.where(listPredicates.toArray(new Predicate[0]));

        return entityManager.createQuery(bladeEntityQuery);
//        queryCustom.setMaxResults(10000);
    }
}
