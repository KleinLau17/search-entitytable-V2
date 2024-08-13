package com.shangxun.search.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 聚合搜索
 */
@Data
public class SearchVO implements Serializable {

    private List<PostVO> postList;

//    private List<Picture> pictureList;

    private List<EntityTableVO> entityTableList;

    private List<?> dataList;

    private static final long serialVersionUID = 1L;

}
