package com.ovit.bee.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据字典
 * @author Administrator
 *
 */
public class SysDict {
    private Integer id;

    private String dictName;

    private String dictValue;

   // private Integer parentId;

    private Integer status;
    
    private List<SysDict> children=new ArrayList<>();
    
    private SysDict parent;
    
    

    public List<SysDict> getChildren() {
		return children;
	}

	public void setChildren(List<SysDict> children) {
		this.children = children;
	}

	public SysDict getParent() {
		return parent;
	}

	public void setParent(SysDict parent) {
		this.parent = parent;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue == null ? null : dictValue.trim();
    }

   /* public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }*/

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}