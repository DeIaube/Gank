package com.example.administrator.fuckgank.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public class GankDayItem {

    @Override
    public String toString() {
        return "GankDayItem{" +
                "error=" + error +
                ", results=" + results +
                ", category=" + category +
                '}';
    }

    /**
     * category : ["瞎推荐","前端","休息视频","App","Android","福利","iOS"]
     * error : false
     * results : {"Android":[{"_id":"585f98ce421aa9723a5a77c1","createdAt":"2016-12-25T18:00:46.216Z","desc":"RxJava实现的图片选择库","publishedAt":"2016-12-26T11:40:05.242Z","source":"chrome","type":"Android","url":"https://github.com/miguelbcr/RxPaparazzo","used":true,"who":"jp"},{"_id":"58606ebe421aa9723d29b9a2","createdAt":"2016-12-26T09:13:34.699Z","desc":"玩玩支付宝AR红包，通过简单的图像处理，还原线索图片，成功抢红包👍 附有源码~","publishedAt":"2016-12-26T11:40:05.242Z","source":"web","type":"Android","url":"https://blog.fangjie.info/2016/12/23/%E7%8E%A9%E7%8E%A9%E6%94%AF%E4%BB%98%E5%AE%9DAR%E7%BA%A2%E5%8C%85/","used":true,"who":"方杰"},{"_id":"5860851f421aa9723d29b9a5","createdAt":"2016-12-26T10:49:03.813Z","desc":"Android Key 生成，存储，加密工具库。","publishedAt":"2016-12-26T11:40:05.242Z","source":"chrome","type":"Android","url":"https://github.com/yakivmospan/scytale","used":true,"who":"代码家"},{"_id":"58608576421aa9723a5a77cd","createdAt":"2016-12-26T10:50:30.802Z","desc":"多种图片样式 UI 组合，很适合做头像相关的功能。","images":["http://img.gank.io/b12f9a6c-024d-4974-9cfe-fe42f471a3af"],"publishedAt":"2016-12-26T11:40:05.242Z","source":"chrome","type":"Android","url":"https://github.com/stfalcon-studio/MultiImageView","used":true,"who":"代码家"},{"_id":"58608596421aa9723a5a77ce","createdAt":"2016-12-26T10:51:02.683Z","desc":"Android HTML to TextView Builder 辅助工具库。","images":["http://img.gank.io/47df6353-9a3e-47e1-af56-9c36502720a5"],"publishedAt":"2016-12-26T11:40:05.242Z","source":"chrome","type":"Android","url":"https://github.com/jrummyapps/html-builder","used":true,"who":"代码家"}],"App":[{"_id":"585f3320421aa97240ef9f2f","createdAt":"2016-12-25T10:46:56.528Z","desc":"知乎热门榜-知乎热门问题","images":["http://img.gank.io/3392f47e-d341-41ac-a41c-3b24d62a8789"],"publishedAt":"2016-12-26T11:40:05.242Z","source":"web","type":"App","url":"https://github.com/jiang111/ZhiHu-TopAnswer","used":true,"who":"NewTab"}],"iOS":[{"_id":"586080b6421aa97240ef9f32","createdAt":"2016-12-26T10:30:14.823Z","desc":"致力于提高项目 UI 开发效率的解决方案","publishedAt":"2016-12-26T11:40:05.242Z","source":"chrome","type":"iOS","url":"http://qmuiteam.com/ios/page/index.html","used":true,"who":"代码家"}],"休息视频":[{"_id":"585e7202421aa97240ef9f2d","createdAt":"2016-12-24T21:02:58.324Z","desc":"暖心动画短片《安娜和她的云》\u2026\u2026有时候，最美的惊喜并不是得到，而是学会付出。","publishedAt":"2016-12-26T11:40:05.242Z","source":"chrome","type":"休息视频","url":"http://weibo.com/tv/v/a231c7cda5adcec95c93ae5892c65e0d?fid=1034:a231c7cda5adcec95c93ae5892c65e0d","used":true,"who":"LHF"}],"前端":[{"_id":"585e3e74421aa97240ef9f2c","createdAt":"2016-12-24T17:23:00.35Z","desc":"『微信小程序』征服指南，最全资源集合","publishedAt":"2016-12-26T11:40:05.242Z","source":"web","type":"前端","url":"https://masterstudio.github.io/MasterWechatApp/","used":true,"who":"wangyf"},{"_id":"585ea247421aa9723d29b99a","createdAt":"2016-12-25T00:28:55.974Z","desc":"React还是Vue：你该如何选择？","publishedAt":"2016-12-26T11:40:05.242Z","source":"web","type":"前端","url":"https://zhuanlan.zhihu.com/p/24548677","used":true,"who":"王下邀月熊(Chevalier)"}],"瞎推荐":[{"_id":"585d4908421aa97237bca8f3","createdAt":"2016-12-23T23:55:52.395Z","desc":"Python语法速览与机器学习开发环境搭建","publishedAt":"2016-12-26T11:40:05.242Z","source":"web","type":"瞎推荐","url":"https://zhuanlan.zhihu.com/p/24536868","used":true,"who":"王下邀月熊(Chevalier)"}],"福利":[{"_id":"58606820421aa9723d29b9a1","createdAt":"2016-12-26T08:45:20.537Z","desc":"12-26","publishedAt":"2016-12-26T11:40:05.242Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034jw1fb3whph0ilj20u00na405.jpg","used":true,"who":"daimajia"}]}
     */

    private boolean error;
    private ResultsBean results;
    private List<String> category;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public ResultsBean getResults() {
        return results;
    }

    public void setResults(ResultsBean results) {
        this.results = results;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public static class ResultsBean {
        private List<AndroidBean> Android;
        private List<AppBean> App;
        private List<IOSBean> iOS;
        private List<休息视频Bean> 休息视频;
        private List<前端Bean> 前端;
        private List<瞎推荐Bean> 瞎推荐;
        private List<福利Bean> 福利;
        private List<拓展资源Bean> 拓展资源;

        @Override
        public String toString() {
            return "ResultsBean{" +
                    "Android=" + Android +
                    ", App=" + App +
                    ", iOS=" + iOS +
                    ", 休息视频=" + 休息视频 +
                    ", 前端=" + 前端 +
                    ", 瞎推荐=" + 瞎推荐 +
                    ", 福利=" + 福利 +
                    '}';
        }

        public List<AndroidBean> getAndroid() {
            return Android;
        }

        public void setAndroid(List<AndroidBean> Android) {
            this.Android = Android;
        }


        public void set拓展资源(List<拓展资源Bean> 拓展资源) {
            this.拓展资源 = 拓展资源;
        }

        public List<拓展资源Bean> get拓展资源() {
            return 拓展资源;
        }

        public List<AppBean> getApp() {
            return App;
        }

        public void setApp(List<AppBean> App) {
            this.App = App;
        }

        public List<IOSBean> getIOS() {
            return iOS;
        }

        public void setIOS(List<IOSBean> iOS) {
            this.iOS = iOS;
        }

        public List<休息视频Bean> get休息视频() {
            return 休息视频;
        }

        public void set休息视频(List<休息视频Bean> 休息视频) {
            this.休息视频 = 休息视频;
        }

        public List<前端Bean> get前端() {
            return 前端;
        }

        public void set前端(List<前端Bean> 前端) {
            this.前端 = 前端;
        }

        public List<瞎推荐Bean> get瞎推荐() {
            return 瞎推荐;
        }

        public void set瞎推荐(List<瞎推荐Bean> 瞎推荐) {
            this.瞎推荐 = 瞎推荐;
        }

        public List<福利Bean> get福利() {
            return 福利;
        }

        public void set福利(List<福利Bean> 福利) {
            this.福利 = 福利;
        }

        public static class AndroidBean extends BaseBean{
        }

        public static class AppBean extends BaseBean{
        }

        public static class IOSBean extends BaseBean{
        }

        public static class 休息视频Bean extends BaseBean{
        }

        public static class 前端Bean extends BaseBean{
        }

        public static class 瞎推荐Bean extends BaseBean{
        }

        public static class 福利Bean extends BaseBean{
        }

        public static class 拓展资源Bean extends BaseBean{
        }
    }


    public List<BaseBean> getGankList(){
        List<ResultsBean.福利Bean> 福利 = results.get福利() == null ? new ArrayList<ResultsBean.福利Bean>() : results.get福利();
        List<ResultsBean.AndroidBean> android = results.getAndroid() == null ? new ArrayList<ResultsBean.AndroidBean>() : results.getAndroid();
        List<ResultsBean.IOSBean> ios = results.getIOS() == null ? new ArrayList<ResultsBean.IOSBean>() : results.getIOS();
        List<ResultsBean.AppBean> app = results.getApp() == null ? new ArrayList<ResultsBean.AppBean>() : results.getApp();
        List<ResultsBean.前端Bean> 前端 = results.get前端() == null ? new ArrayList<ResultsBean.前端Bean>() : results.get前端();
        List<ResultsBean.瞎推荐Bean> 瞎推荐 = results.get瞎推荐() == null ? new ArrayList<ResultsBean.瞎推荐Bean>() : results.get瞎推荐();
        List<ResultsBean.休息视频Bean> 休息视频 = results.get休息视频() == null ? new ArrayList<ResultsBean.休息视频Bean>() : results.get休息视频();
        List<ResultsBean.拓展资源Bean> 拓展资源 = results.get拓展资源() == null ? new ArrayList<ResultsBean.拓展资源Bean>() : results.get拓展资源();
        List<BaseBean> result = new ArrayList<>();


        BaseBean titleBean = null;

        titleBean = new BaseBean();
        titleBean.setUrl(福利.get(0).getUrl());
        result.add(titleBean);


        titleBean = new BaseBean();
        titleBean.setDesc("Android");
        if(!android.isEmpty()){
            result.add(titleBean);
        }
        result.addAll(android);


        titleBean = new BaseBean();
        titleBean.setDesc("iOS");
        if(!ios.isEmpty()){
            result.add(titleBean);
        }
        result.addAll(ios);


        titleBean = new BaseBean();
        titleBean.setDesc("App");
        if(!app.isEmpty()){
            result.add(titleBean);
        }
        result.addAll(app);


        titleBean = new BaseBean();
        titleBean.setDesc("前端");
        if(!前端.isEmpty()){
            result.add(titleBean);
        }
        result.addAll(前端);

        titleBean = new BaseBean();
        titleBean.setDesc("拓展资源");
        if(!拓展资源.isEmpty()){
            result.add(titleBean);
        }
        result.addAll(拓展资源);

        titleBean = new BaseBean();
        titleBean.setDesc("瞎推荐");
        if(!瞎推荐.isEmpty()){
            result.add(titleBean);
        }
        result.addAll(瞎推荐);

        titleBean = new BaseBean();
        titleBean.setDesc("休息视频");
        if(!休息视频.isEmpty()){
            result.add(titleBean);
        }
        result.addAll(休息视频);


        return result;
    }
}
