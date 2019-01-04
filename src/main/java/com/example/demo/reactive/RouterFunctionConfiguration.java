package com.example.demo.reactive;

import com.example.demo.domain.SysUserBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GO:
 * Created By JiWei.Chen 2018-12-13
 */
@Configuration
public class RouterFunctionConfiguration {

    /**
     * serverRequest httpServletRequest
     * serverResponse httpServletResponse
     * 对象集合：reactive异步处理-非阻塞
     *  flux 0-n
     *  mono 0-1
     *
     * List Old集合同步处理 - 阻塞
     */
    @Bean
    public RouterFunction<ServerResponse> test(){
        return RouterFunctions.route(RequestPredicates.GET("/find/all"),
                request->{
                    Map<Long, SysUserBean> map = new HashMap<>();
                    List<SysUserBean> list = new ArrayList<>();
                    map.forEach((k, v) -> {
                        list.add(v);
                    });
                    Flux<SysUserBean> flux = Flux.fromIterable(list);
                    return ServerResponse.ok().body(flux, SysUserBean.class);
                });
    }
}
