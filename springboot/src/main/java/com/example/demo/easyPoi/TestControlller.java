package com.example.demo.easyPoi;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.exception.excel.ExcelImportException;
import com.example.demo.dto.easypoi.TransferAccountManageDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.*;

@Api(tags = {"测试easypoi功能"})
@RestController
@RequestMapping("/easypoi")
public class TestControlller {
    @Autowired
    private ObjectMapper mapper;

    @ApiOperation("解析excel中的数据")
    @PostMapping("/resolver")
    public Map<Integer,String> uploadResolve(@RequestParam(value = "file",required = true)MultipartFile file) throws Exception{
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        params.setImportFields(EasyPoiUtil.getHeaders(AddModel_Excel.class));
        List<AddModel_Excel> list =new ArrayList<>();
        try {
            //excel导出功能
            ExcelImportResult<AddModel_Excel> result = ExcelImportUtil.importExcelMore(file.getInputStream(), AddModel_Excel.class, params);
            list = result.getList();
        } catch (ExcelImportException e) {
            e.printStackTrace();
            return new HashMap(){{
                put("code",0);
                put("message","模板错误");
            }};
        }catch (Exception e) {
            e.printStackTrace();
        }
        TransferAccountManageDto dto = null;
        ArrayList<TransferAccountManageDto> arr = new ArrayList<>();
        LinkedHashMap<Integer,String> linkedList=new LinkedHashMap<>();
        for (AddModel_Excel m : list) {
            dto = new TransferAccountManageDto();
            BeanUtils.copyProperties(m, dto);
            dto.setInputPerson("dick");
            if (m.getTransferTime() != null) {
                dto.setTransferTime(new SimpleDateFormat("yyyy-MM-dd").format(m.getTransferTime()));
            }
            arr.add(dto);
        }
        for (int i = 0; i < arr.size(); i++) {
            TransferAccountManageDto transferAccountManageDto = arr.get(i);
            System.err.println(transferAccountManageDto.getTransferTime()+"  "+transferAccountManageDto.getSerialNumber()+"  "+transferAccountManageDto.getBankName()+"  "+transferAccountManageDto.getCustomerName()+":"+transferAccountManageDto.getCustomerName().length()+"  "+transferAccountManageDto.getTransferAmount()+"  "+transferAccountManageDto.getRechargeAmount());
            linkedList.put(i,this.mapper.writeValueAsString(transferAccountManageDto));
        }
        return linkedList;
    }
}
