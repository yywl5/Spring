package Mappers.potatob6;

import Beans.potatob6.Administrator;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminAdminsMapper {

    // 查询指定页数的管理员列表
    List<Administrator> getPageOfAdmin(@Param("startIndex") Integer startIndex, @Param("pageCount") Integer pageCount);

    // 编辑管理员
    Integer editAdmin(Administrator admin);

    // 删除管理员
    Integer deleteAdmin(@Param("adminId") Integer adminId);

    // 添加图书
    Integer addAdmin(Administrator admin) throws Exception;

    // 查询图书
    List<Administrator> searchAdmin(@Param("words") String words);

}
