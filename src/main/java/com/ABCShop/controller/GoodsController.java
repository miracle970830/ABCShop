package com.ABCShop.controller;

import com.ABCShop.common.FileUploadUtils;
import com.ABCShop.entity.Goods;
import com.ABCShop.entity.GoodsType;
import com.ABCShop.service.GoodsService;
import com.alibaba.fastjson.JSON;
import com.ABCShop.common.ServerLayResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

/**
 * 商品控制器
 */
@Api("商品接口API")
@RestController
public class GoodsController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private GoodsService goodsService;

    private String image = "";

    public static void main(String[] args) {

        String s = DigestUtils.md5DigestAsHex("123".getBytes());
        System.out.println("新密码："+s);
    }

    @ApiOperation(value = "商品列表接口", notes = "商品结果集列表")
    @GetMapping("/admin/goodsList")
    public ServerLayResult<Goods> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                       @RequestParam(value = "limit", defaultValue = "10") Integer limit, @RequestParam(value = "keyword", defaultValue = "") String keyword) {
        //查询结果总数
        int count = goodsService.count(keyword);
        List<Goods> goods = goodsService.selectAll(page, limit,keyword);
        //组装Json数据
        ServerLayResult result = new ServerLayResult(0, "", count, goods);
        return result;
    }

    @ApiOperation(value = "商品删除接口", notes = "根据商品ID删除商品")
    @GetMapping("/admin/goods/del")
    public String delete(Integer id) {
        System.out.println("id = " + id);
        int row = goodsService.deleteByPrimaryKey(id);
        if (row > 0) {
            return "success";
        }
        return "error";
    }

    @ApiOperation(value = "商品批量删除接口", notes = "根据商品IDS删除商品")
    @GetMapping("/admin/goods/delids")
    public String delids(String ids) {
        System.out.println("id = " + ids);
        List<Integer> id=new ArrayList<>();
        int row=0;
        for (String s : ids.split(",")) {
             row += goodsService.deleteByPrimaryKey(Integer.parseInt(s));
        }

        if (row > 0) {
            return "success";
        }
        return "error";
    }

    @ApiOperation(value = "商品更新接口", notes = "根据json数据对象来更新接口")
    @PostMapping("/admin/goods/update")
    public String update(@RequestBody JSONObject ob) {
        com.alibaba.fastjson.JSONObject json = JSON.parseObject(ob.toJSONString());
        logger.info(ob.toJSONString());
        String gname = json.getString("gname");
        Integer id = json.getInteger("id");
        Double goprice = json.getDouble("goprice");
        Double grprice = json.getDouble("grprice");
        Integer gstore = json.getInteger("gstore");
        String goodstypeId = json.getString("goodstypeId");
        if (goodstypeId == null) {
            return "error";
        }
        Goods goods = new Goods();
        goods.setId(id);
        goods.setGname(gname);
        goods.setGoprice(goprice);
        goods.setGrprice(grprice);
        goods.setGstore(gstore);
        GoodsType goodsType = new GoodsType();
        goodsType.setId(Integer.parseInt(goodstypeId));
        goods.setGoodstypeId(goodsType);
        goods.setIputTime(new Date());

        goods.setGpicture("http://localhost:8080/views/upload/" + image);
        logger.info(String.valueOf(goods));
        int insert = goodsService.updateByPrimaryKey(goods);
        if (insert > 0) {
            return "success";
        }
        return "error";
    }

    @ApiOperation(value = "商品保存接口", notes = "根据json数据来保存商品")
    @PostMapping("/admin/goods/add")
    public String addGoods(@RequestBody JSONObject ob) {
        com.alibaba.fastjson.JSONObject json = JSON.parseObject(ob.toJSONString());
        String gname = json.getString("gname");
        Double goprice = json.getDouble("goprice");
        Double grprice = json.getDouble("grprice");
        Integer gstore = json.getInteger("gstore");
        String goodstypeId = json.getString("goodstypeId");
        Goods goods = new Goods();
        goods.setGname(gname);
        goods.setGoprice(goprice);
        goods.setGrprice(grprice);
        goods.setGstore(gstore);
        GoodsType goodsType = new GoodsType();
        goodsType.setId(Integer.parseInt(goodstypeId));
        goods.setGoodstypeId(goodsType);
        goods.setIputTime(new Date());

        goods.setGpicture("http://localhost:8080/views/upload/" + image);
        int insert = goodsService.insert(goods);
        if (insert > 0) {
            return "success";
        }
        return "error";
    }

    /**
     * 实现文件上传
     */
    @ApiOperation(value = "图片上传接口", notes = "根据MultipartFile类上传文件")
    @PostMapping(value = "/admin/uploadImg")
    public Map<String, Object> ramanage(@RequestParam("file") MultipartFile file,
                                        HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        try {
            //获取跟目录
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if (!path.exists()) path = new File("");
            System.out.println("path:" + path.getAbsolutePath());
            File upload = new File(path.getAbsolutePath(), "static/images/upload/");
            if (!upload.exists())
                upload.mkdirs();
            String realPath = path.getAbsolutePath() + "/static/views/upload";
            request.setAttribute("path", realPath);
            image = FileUploadUtils.uploadFile(file, realPath);
            result.put("code", 0);
            result.put("image", image);
        } catch (Exception e) {
            result.put("code", 1);
            e.printStackTrace();
        }
        return result;
    }


}
