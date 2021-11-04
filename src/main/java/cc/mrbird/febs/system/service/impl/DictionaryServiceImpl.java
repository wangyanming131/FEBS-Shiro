package cc.mrbird.febs.system.service.impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.system.entity.Dictionary;
import cc.mrbird.febs.system.mapper.DictionaryMapper;
import cc.mrbird.febs.system.service.IDictionaryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 *  Service实现
 *
 * @author wangyanming
 * @date 2021-11-04 15:22:01
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements IDictionaryService {

    private final DictionaryMapper dictionaryMapper;

    @Override
    public IPage<Dictionary> findDictionarys(QueryRequest request, Dictionary dictionary) {
        LambdaQueryWrapper<Dictionary> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Dictionary> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Dictionary> findDictionarys(Dictionary dictionary) {
	    LambdaQueryWrapper<Dictionary> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createDictionary(Dictionary dictionary) {
        this.save(dictionary);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateDictionary(Dictionary dictionary) {
        this.saveOrUpdate(dictionary);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteDictionary(Dictionary dictionary) {
        LambdaQueryWrapper<Dictionary> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}
}
