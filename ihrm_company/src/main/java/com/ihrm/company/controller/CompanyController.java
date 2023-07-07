package com.ihrm.company.controller;

import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.company.service.CompanyService;
import com.ihrm.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /**
     * 保存
     * @param company
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Result save(@RequestBody Company company){
        companyService.add(company);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 更新
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable(value = "id") String id,@RequestBody Company company){
        company.setId(id);
        companyService.update(company);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 根据ID删除
     */
    @RequestMapping(value = "/delById/{id}",method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable(value = "id") String id){
        companyService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 根据ID查询
     */
    @RequestMapping(value = "/findById/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable(value = "id") String id){
        Company company = companyService.findById(id);
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(company);
        return result;
    }

    /**
     * 查询所有企业
     */
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public Result findAll(){
        List<Company> company = companyService.findAll();
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(company);
        return result;
    }
}
