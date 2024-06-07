package com.poscodx.odc.excan013.service.rest;

import com.google.gson.JsonObject;
import com.poscdx.odc.excan013.domain.entity.ExcanCategory;
import com.poscdx.odc.excan013.domain.lifecycle.ServiceLifecycle;
import com.poscdx.odc.excan013.domain.spec.ExcanCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Router API for category Class
 *
 * @author 202290_nh.hung724
 * @since 2023-12
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/category")
public class CategoryResource {

    private final ServiceLifecycle serviceLifecycle;

    /**
     * Retrieves a list of all ExcanCategory objects.
     *
     * @return List<ExcanCategory>: a list of all ExcanCategory objects
     * @author 202290_nh.hung724
     * @since 2023-12
     */
    @CrossOrigin
    @GetMapping(path = "/all")
//    @PreAuthorize("hasAuthority('GET_CATEGORY')")
    public List<ExcanCategory> findAll() {
        return this.serviceLifecycle.requestExcanCategoryService().findAll();
    }

    /**
     * Retrieves a ExcanCategory objects by the given id.
     *
     * @param id: the ID of the ExcanCategory to search for
     * @return ExcanQuestion: a ExcanCategory objects
     * @author 202290_nh.hung724
     * @since 2023-12
     */
    @CrossOrigin
    @GetMapping(path = "/{id}")
//    @PreAuthorize("hasAuthority('GET_CATEGORY')")
    public ExcanCategory find(@PathVariable("id") int id) {
        return this.serviceLifecycle.requestExcanCategoryService().find(id);
    }

    /**
     * Create new ExcanCategory
     *
     * @param excanCategory: a object data to create new ExcanCategory
     * @return ExcanCategory: a ExcanCategory objects
     * @author 202290_nh.hung724
     * @since 2023-12
     */
    @CrossOrigin
    @PostMapping(path = "")
//    @PreAuthorize("hasAuthority('ADD_CATEGORY')")
    public ExcanCategory register(@RequestBody ExcanCategory excanCategory) {
        return this.serviceLifecycle.requestExcanCategoryService().register(excanCategory);
    }

    /**
     * Update an existed ExcanCategory
     *
     * @param updateExcanCategoryData: a JSON contain data to update an existed ExcanCategory
     * @return ExcanCategory: a ExcanCategory objects
     * @author 202290_nh.hung724
     * @since 2023-12
     */
    @CrossOrigin
    @PutMapping(path = "")
//    @PreAuthorize("hasAuthority('UPDATE_CATEGORY')")
    public ExcanCategory updateCategory(@RequestBody JsonObject updateExcanCategoryData) {
        ExcanCategoryService excanCategoryService = this.serviceLifecycle.requestExcanCategoryService();
        ExcanCategory excanCategory = excanCategoryService.find(updateExcanCategoryData.get("id").getAsInt());
        excanCategory.setName(updateExcanCategoryData.get("name").getAsString());
        return excanCategoryService.register(excanCategory);
    }

    /**
     * Delete an existed ExcanCategory
     *
     * @param id: Delete an existed ExcanCategory by provided id
     * @return void: No return
     * @author 202290_nh.hung724
     * @since 2023-12
     */
//    @CrossOrigin
//    @DeleteMapping(path = "/{id}")
//    @PreAuthorize("hasAuthority('DELETE_CATEGORY')")
//    public void remove(@PathVariable("id") int id) {
//        this.serviceLifecycle.requestExcanCategoryService().remove(id);
//    }
}
