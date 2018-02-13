package com.biyao.book.action;

import com.biyao.book.dao.IBookIntroductDAO;
import com.biyao.book.dao.IBookShoppingDAO;
import com.biyao.book.model.BookIntroduct;
import com.biyao.book.model.BookIntroductExample;
import com.biyao.book.model.BookShopping;
import com.biyao.book.model.BookShoppingExample;
import com.biyao.common.base.Message;
import com.biyao.common.util.ObjToJson;
import com.biyao.system.model.SysUserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hxs
 * @Description:我的购物车
 * @Date:on 2018/1/18
 */

@Controller
@RequestMapping("/shopping")
public class MyShopping {

    @Resource
    private IBookShoppingDAO iBookShoppingDAO;

    private Message message = null;
    private ObjToJson objToJson = new ObjToJson();

    //将已选书目加入您的求借和索取清单
    @ResponseBody
    @RequestMapping("/addBookShop")
    public String addBookShop(HttpServletRequest request, Model model) {

        //获取当前用户
        SysUserInfo currentUser = (SysUserInfo) request.getSession().getAttribute("currentUser");
        message = new Message();
        try {

            Date date = new Date();
            String bookIds = request.getParameter("bookIds");
            String[] ids = bookIds.split(",");
            for(int i=0;i<ids.length;i++){
                BookShopping shop = new BookShopping();
                shop.setBookId(Integer.parseInt(ids[i]));
                shop.setBookAccount(currentUser.getLoginAccount());
                shop.setCreateTime(date);
                shop.setUpdateTime(date);
                iBookShoppingDAO.insert(shop);
            }
            message.setContent("已添加购物车");
            message.setShow("true");
        }catch(Exception e){
            e.printStackTrace();
            message.setContent("未添加购物车");
            message.setShow("false");
        }

        String json=objToJson.getJson(message);
        return json;
    }

    //展示购物车
    @RequestMapping("/showShopping")
    public String editBookShow(HttpServletRequest request, Model model){

        //获取当前用户
        SysUserInfo currentUser = (SysUserInfo) request.getSession().getAttribute("currentUser");

        //获取该用户的购物车
        List<Map> bookShoppings = iBookShoppingDAO.selectShopping(currentUser.getLoginAccount());
        model.addAttribute("bookShoppings",bookShoppings);
        return "myShopping/shopList";
    }

    //删除书目
    @RequestMapping("/delShopping/{id}")
    public String delShopping(@PathVariable int id, HttpServletRequest request){

        //获取该用户的购物车
        iBookShoppingDAO.deleteByPrimaryKey(id);
        return "forward:/shopping/showShopping";
    }

    //汇总书目
    @RequestMapping("/collectBook")
    public String collectBook(HttpServletRequest request,Model model){

        //获取当前用户
        SysUserInfo currentUser = (SysUserInfo) request.getSession().getAttribute("currentUser");

        String[] shows = request.getParameterValues("show");
        String[] shoppingIds = request.getParameterValues("shoppingId");
        String ids = "";
        List<Map> bookShoppings = null;
        if(shows != null && shows.length>0){
            for(int i=0;i<shows.length;i++){
                if(!StringUtils.isEmpty(shows[i])){
                    ids = ids + shoppingIds[i] + ",";
                }
            }
            ids = ids.substring(0,ids.length()-1);

            Map map = new HashMap();
            map.put("bookAccount",currentUser.getLoginAccount());
            map.put("ids",ids);
            bookShoppings = iBookShoppingDAO.collectShopping(map);
        }
        model.addAttribute("bookShoppings",bookShoppings);
        return "myShopping/collectList";
    }

}
