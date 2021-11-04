package cc.mrbird.febs.system.service;

import cc.mrbird.febs.system.entity.Dictionary;

import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author wangyanming
 * @date 2021-11-04 15:22:01
 */
public interface IDictionaryService extends IService<Dictionary> {
    /**
     * 查询（分页）
     *
     * @param request    QueryRequest
     * @param dictionary dictionary
     * @return IPage<Dictionary>
     */
    IPage<Dictionary> findDictionarys(QueryRequest request, Dictionary dictionary);

    /**
     * 查询（所有）
     *
     * @param dictionary dictionary
     * @return List<Dictionary>
     */
    List<Dictionary> findDictionarys(Dictionary dictionary);

    /**
     * 新增
     *
     * @param dictionary dictionary
     */
    void createDictionary(Dictionary dictionary);

    /**
     * 修改
     *
     * @param dictionary dictionary
     */
    void updateDictionary(Dictionary dictionary);

    /**
     * 删除
     *
     * @param dictionary dictionary
     */
    void deleteDictionary(Dictionary dictionary);
}
