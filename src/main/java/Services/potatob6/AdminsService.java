package Services.potatob6;

import Beans.potatob6.Administrator;
import Mappers.potatob6.AdminAdminsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("PBAdminsService")
public class AdminsService {

    @Autowired
    @Qualifier("PBAdminAdminsDAO")
    private AdminAdminsMapper adminAdminsMapper;

    private static Integer numberOfPages = 20;

    // 查询一页图书
    public List<Administrator> getPageOfAdmin(Integer page) {
        return adminAdminsMapper.getPageOfAdmin(numberOfPages*(page-1), numberOfPages);
    }

    // 编辑管理员
    public Integer editAdmin(String _adminId, String _adminLogin, String _adminName,
                            String _adminPassword, String _avatarPath) throws Exception {
        Integer adminId = Integer.parseInt(_adminId);
        Administrator admin = new Administrator(adminId, _adminLogin, _adminName, _adminPassword, _avatarPath);
        System.out.println(admin);
        return adminAdminsMapper.editAdmin(admin);
    }

    // 删除管理员
    public Integer deleteAdmin(Integer adminId) {
        return adminAdminsMapper.deleteAdmin(adminId);
    }

    // 添加管理员
    public Integer addAdmin(Administrator admin) {
        try {
            return adminAdminsMapper.addAdmin(admin);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    // 查询管理员
    public List<Administrator> searchAdmin(String words) {
        return adminAdminsMapper.searchAdmin(words);
    }

}
