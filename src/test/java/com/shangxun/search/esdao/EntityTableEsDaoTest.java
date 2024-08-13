package com.shangxun.search.esdao;

import com.shangxun.search.model.dto.entityTable.EntityTableEsDTO;
import com.shangxun.search.model.dto.post.PostEsDTO;
import com.shangxun.search.service.EntityTableService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * EntityTable ES 操作测试
 */
@SpringBootTest
public class EntityTableEsDaoTest {

    @Resource
    private EntityTableEsDao entityTableEsDao;

    @Resource
    private EntityTableService entityTableService;

//
//    @Test
//    void test() {
//        PostQueryRequest postQueryRequest = new PostQueryRequest();
//        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Post> page =
//                postService.searchFromEs(postQueryRequest);
//        System.out.println(page);
//    }

//    @Test
//    void testSelect() {
//        System.out.println(postEsDao.count());
//        Page<PostEsDTO> PostPage = postEsDao.findAll(
//                PageRequest.of(0, 5, Sort.by("createTime")));
//        List<PostEsDTO> postList = PostPage.getContent();
//        Optional<PostEsDTO> byId = postEsDao.findById(2L);
//        System.out.println(byId);
//        System.out.println(postList);
//    }
//
//    @Test
//    void testAdd() {
//        PostEsDTO postEsDTO = new PostEsDTO();
//        postEsDTO.setId(2L);
//        postEsDTO.setTitle("大香蕉");
//        postEsDTO.setContent("大香蕉，一个大香蕉，你的感觉真的很奇妙");
//        postEsDTO.setTags(Arrays.asList("java", "golang"));
//        postEsDTO.setCreateTime(new Date());
//        postEsDTO.setUpdateTime(new Date());
//        postEsDTO.setIsDelete(0);
//        postEsDao.save(postEsDTO);
//        System.out.println(postEsDTO.getId());
//    }
//
//    @Test
//    void testFindById() {
//        Optional<PostEsDTO> postEsDTO = postEsDao.findById(1L);
//        System.out.println(postEsDTO);
//    }
//
//    @Test
//    void testCount() {
//        System.out.println(postEsDao.count());
//    }
//
//    @Test
//    void testFindByCategory() {
//        List<PostEsDTO> postEsDaoTestList = postEsDao.findByTitle("香蕉");
//        System.out.println(postEsDaoTestList);
//    }
//
    @Test
    void testFindByCodeName() {
        List<EntityTableEsDTO> entityTableEsDTO = entityTableEsDao.findByCodeName("香蕉");
        System.out.println(entityTableEsDTO);
    }

    @Test
    void testCount() {
        System.out.println(entityTableEsDao.count());
    }
}
