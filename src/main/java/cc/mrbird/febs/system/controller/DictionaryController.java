package cc.mrbird.febs.system.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.system.entity.Dictionary;
import cc.mrbird.febs.system.service.IDictionaryService;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Controller
 *
 * @author wangyanming
 * @date 2021-11-04 15:22:01
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class DictionaryController extends BaseController {

    private final IDictionaryService dictionaryService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "dictionary")
    public String dictionaryIndex() {
        return FebsUtil.view("dictionary/dictionary");
    }

    @GetMapping("dictionary")
    @ResponseBody
    @RequiresPermissions("dictionary:list")
    public FebsResponse getAllDictionarys(Dictionary dictionary) {
        return new FebsResponse().success().data(dictionaryService.findDictionarys(dictionary));
    }

    @GetMapping("dictionary/list")
    @ResponseBody
    @RequiresPermissions("dictionary:list")
    public FebsResponse dictionaryList(QueryRequest request, Dictionary dictionary) {
        Map<String, Object> dataTable = getDataTable(this.dictionaryService.findDictionarys(request, dictionary));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增Dictionary", exceptionMessage = "新增Dictionary失败")
    @PostMapping("dictionary")
    @ResponseBody
    @RequiresPermissions("dictionary:add")
    public FebsResponse addDictionary(@Valid Dictionary dictionary) {
        this.dictionaryService.createDictionary(dictionary);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Dictionary", exceptionMessage = "删除Dictionary失败")
    @GetMapping("dictionary/delete")
    @ResponseBody
    @RequiresPermissions("dictionary:delete")
    public FebsResponse deleteDictionary(Dictionary dictionary) {
        this.dictionaryService.deleteDictionary(dictionary);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Dictionary", exceptionMessage = "修改Dictionary失败")
    @PostMapping("dictionary/update")
    @ResponseBody
    @RequiresPermissions("dictionary:update")
    public FebsResponse updateDictionary(Dictionary dictionary) {
        this.dictionaryService.updateDictionary(dictionary);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Dictionary", exceptionMessage = "导出Excel失败")
    @PostMapping("dictionary/excel")
    @ResponseBody
    @RequiresPermissions("dictionary:export")
    public void export(QueryRequest queryRequest, Dictionary dictionary, HttpServletResponse response) {
        List<Dictionary> dictionarys = this.dictionaryService.findDictionarys(queryRequest, dictionary).getRecords();
        ExcelKit.$Export(Dictionary.class, response).downXlsx(dictionarys, false);
    }
}
