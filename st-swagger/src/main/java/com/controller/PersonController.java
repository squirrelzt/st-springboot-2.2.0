package com.controller;

import com.cache.Cache;
import com.domain.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/person")
@Api(value = "人api接口", tags = "人api接口")
public class PersonController {

    @Resource
    private Cache<Person> cache;

    @GetMapping
    @ApiOperation(value = "查询", notes = "name参数，查询指定名称的数据")
    public Person select(@RequestParam @ApiParam String name) {
        return cache.get(name);
    }

    @PostMapping
    @ApiOperation(value = "新增", notes = "新增单条数据")
    public void add(@RequestBody @ApiParam Person person) {
        cache.addOrUpdateCache(person.getName(), person);
    }

    @PutMapping
    @ApiOperation(value = "更新", notes = "更新单条数据")
    public void update(@RequestBody Person person) {
        cache.addOrUpdateCache(person.getName(), person);
    }

    @DeleteMapping
    @ApiOperation(value = "删除", notes = "删除单条数据")
    public void delete(@RequestBody Person person) {
        cache.evictCache(person.getName());
    }
}
