package cc.mrbird.febs.system.entity;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * Entity
 *
 * @author wangyanming
 * @date 2021-11-04 15:22:01
 */
@Data
@TableName("t_dictionary")
public class Dictionary {

    /**
     * 主键,自增
     */
    @TableId(value = "dic_id", type = IdType.AUTO)
    private Integer dicId;

    /**
     * 字典code,某一类字典的统一code
     */
    @TableField("dic_code")
    private String dicCode;

    /**
     * 字典code对应name
     */
    @TableField("dic_name")
    private String dicName;

    /**
     * 字典项value
     */
    @TableField("dic_value")
    private String dicValue;

    /**
     * 字典项value对应显示的text
     */
    @TableField("dic_text")
    private String dicText;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("MODIFY_TIME")
    private Date modifyTime;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

}
