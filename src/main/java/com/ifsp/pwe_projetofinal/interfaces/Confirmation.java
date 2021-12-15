package com.ifsp.pwe_projetofinal.interfaces;

import com.ifsp.pwe_projetofinal.model.User;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:8090/" , name = "confirm")
public interface Confirmation {

    @PostMapping("temp/confirm")
    Object confirmEmail(@RequestBody User user);
}
