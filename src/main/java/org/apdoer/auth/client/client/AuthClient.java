package org.apdoer.auth.client.client;

import org.apdoer.auth.client.dto.ClientTokenDto;
import org.apdoer.common.service.model.po.UserPo;
import org.apdoer.common.service.model.vo.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author apdoer
 * @version 1.0
 * @date 2020/5/18 17:20
 */
@FeignClient("auth-server")
public interface AuthClient {

    /**
     * 获取用户信息
     * @param accessToken
     * @return
     */
    @GetMapping("/userInfo")
    UserPo getUserInfo(@RequestParam("accessToken") String accessToken);

    /**
     * 生成 token
     * @param grantType
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/oauth/token")
    ClientTokenDto getToken(@RequestParam("grantType")String grantType,
                            @RequestParam("username")String username,
                            @RequestParam("password")String password);


    /**
     * 通过用户名获取token
     * @param username
     * @return
     */
    @PostMapping("/username/token")
    ClientTokenDto getToken(@RequestParam("username")String username);

    /**
     * 刷新token
     * @param grantType
     * @param refreshToken
     * @return
     */
    @PostMapping("/refresh/token")
    ClientTokenDto refreshToken(@RequestParam("grantType")String grantType,
                                @RequestParam("refreshToken")String refreshToken);

    /**
     * 撤销token
     * @param accessToken
     * @return
     */
    @DeleteMapping("/oauth/token")
    ResultVo revokeToken(@RequestParam("accessToken") String accessToken);
}
