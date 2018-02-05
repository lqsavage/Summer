package ren.yale.java.controller;

import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.core.http.HttpServerRequest;
import io.vertx.reactivex.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.Session;
import ren.yale.java.SummerResponse;
import ren.yale.java.aop.Before;
import ren.yale.java.bean.Test;
import ren.yale.java.bean.UserInfo;
import ren.yale.java.test.TestInterceptor;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Yale
 *
 * create at:  2018-01-31 17:04
 **/
@Path("/hello")
@Before(TestInterceptor.class)
public class Hello {

    @GET
    @Path("/h1/{id}")
    @Produces({MediaType.TEXT_HTML})
    public String h1(@Context RoutingContext routingContext,
                     @PathParam("id") String id,
                     @DefaultValue("2") @QueryParam("step") int step, String text, @Context HttpServerRequest request,
                     @Context HttpServerResponse response){

        return "<html><body>bbcc</body></html>";
    }

    @POST
    @Path("/h2")
    public Test h2(@QueryParam("test") String test,@FormParam("test1") String test1) {

        return new Test();
    }

    @GET
    @Path("/h3")
    public void h3(@Context HttpServerResponse response, @Context Vertx vertx){
        response.end("<html><body>bb</body></html>");
        UserInfo u = new UserInfo();
        u.setName("bbb");
        u.setPassword("ccc");
    }

    @GET
    @Path("/xml1")
    @Produces({MediaType.TEXT_XML})
    public Test xml1(){
        return new Test();
    }

    @GET
    @Path("/xml2")
    @Produces({MediaType.APPLICATION_XML})
    public Test xml2(){
        return new Test();
    }

    @GET
    @Path("/test")
    public void test(@Context RoutingContext routingContext,
                     @Context HttpServerRequest request,
                     @Context HttpServerResponse response,
                     @Context Session session,
                     @Context Vertx vertx
                       ){

    }

}
