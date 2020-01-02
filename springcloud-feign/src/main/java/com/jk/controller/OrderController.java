package com.jk.controller;

import com.jk.entity.CarBean;
import com.jk.service.OrderServiceFeign;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderServiceFeign orderServiceFeign;

    @Autowired
    private SolrClient solrClient;

  @GetMapping("queryOrder")
    public Map queryOrder(){
        Map<String, String> map = orderServiceFeign.testGetRest();
        return map;
    }



    /*@DeleteMapping("deleteOrder/{orderId}")
    //PathVariable 截取路径中的一部分内容 作为参数传递
    public void deleteOrder(@PathVariable String orderId){
        orderServiceFeign.testRest(orderId);
    }*/

    @RequestMapping("insertOrder")
    public void insertOrder(){


    }


    @RequestMapping("queryCarList")
    @ResponseBody
    public Map<String ,Object > queryCarList (Integer page, Integer rows, CarBean cb){


//        返回前台的map
        HashMap<String,Object> map = new HashMap<String,Object>();
        try {
//      存放所有的查询条件
            SolrQuery params = new SolrQuery();
            if(cb.getCarName() != null && !"".equals(cb.getCarName())){
                params.set("q", cb.getCarName());
            }else {
                params.set("q", "*:*");
            }
            //排序
            params.addSort("carPrice", SolrQuery.ORDER.desc);
            //分页
            if(page == null){
                params.setStart(0);
            }else{
                params.setStart((page-1)*rows);
            }
            if(rows == null){
                params.setRows(5);
            }else{
                params.setRows(rows);
            }
            //默认域
            params.set("df", "product_keywords");
            //高亮
            //打开开关
            params.setHighlight(true);
            //指定高亮域
            params.addHighlightField("carName");
            //设置前缀
            params.setHighlightSimplePre("<span style='color:red'>");
            //设置后缀
            params.setHighlightSimplePost("</span>");
            //查询后返回的对象
            QueryResponse queryResponse = solrClient.query("core1", params);
            //根据查询后返回的对象 获得真正的查询结果
            SolrDocumentList results = queryResponse.getResults();
            System.out.println(results);
            //查询的总条数
            long numFound = results.getNumFound();
            //获取高亮显示的结果, 高亮显示的结果和查询结果是分开放的
            Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
            //创建list集合接收我们循环的参数
            ArrayList<CarBean> list = new ArrayList<CarBean>();
            for (SolrDocument result : results) {
                CarBean carB = new CarBean();
                //获得高亮
                String highli = "";
                Map<String, List<String>> listMap = highlighting.get(result.get("id"));
                List<String> scenicName = listMap.get("carName");
                if(scenicName == null){
                    highli = result.get("carName").toString();
                }else{
                    highli = scenicName.get(0);
                }
                carB.setCarId(Integer.parseInt((String) result.get("id")));
                carB.setCarName(highli);
                carB.setCarCheXi((String) result.get("carCheXi"));
                carB.setCarColor((String) result.get("carColor"));
                carB.setCarPhoto((String) result.get("carPhoto"));
                carB.setCarPingPai((String) result.get("carPingPai"));
                carB.setCarPrice(Integer.parseInt(result.get("carPrice").toString()));
                list.add(carB);
            }
            System.out.println(list);
            map.put("total",numFound);
            map.put("rows",list);
            return map;
        }catch (Exception e){
            e.printStackTrace();
        }


        return map;
    }




}
