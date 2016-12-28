package com.example.administrator.fuckgank.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public class CategoryBean {
    @Override
    public String toString() {
        return "CategoryBean{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }

    /**
     * error : false
     * results : [{"_id":"585f98ce421aa9723a5a77c1","createdAt":"2016-12-25T18:00:46.216Z","desc":"RxJava实现的图片选择库","publishedAt":"2016-12-26T11:40:05.242Z","source":"chrome","type":"Android","url":"https://github.com/miguelbcr/RxPaparazzo","used":true,"who":"jp"},{"_id":"58606ebe421aa9723d29b9a2","createdAt":"2016-12-26T09:13:34.699Z","desc":"玩玩支付宝AR红包，通过简单的图像处理，还原线索图片，成功抢红包👍 附有源码~","publishedAt":"2016-12-26T11:40:05.242Z","source":"web","type":"Android","url":"https://blog.fangjie.info/2016/12/23/%E7%8E%A9%E7%8E%A9%E6%94%AF%E4%BB%98%E5%AE%9DAR%E7%BA%A2%E5%8C%85/","used":true,"who":"方杰"},{"_id":"5860851f421aa9723d29b9a5","createdAt":"2016-12-26T10:49:03.813Z","desc":"Android Key 生成，存储，加密工具库。","publishedAt":"2016-12-26T11:40:05.242Z","source":"chrome","type":"Android","url":"https://github.com/yakivmospan/scytale","used":true,"who":"代码家"},{"_id":"58608576421aa9723a5a77cd","createdAt":"2016-12-26T10:50:30.802Z","desc":"多种图片样式 UI 组合，很适合做头像相关的功能。","images":["http://img.gank.io/b12f9a6c-024d-4974-9cfe-fe42f471a3af"],"publishedAt":"2016-12-26T11:40:05.242Z","source":"chrome","type":"Android","url":"https://github.com/stfalcon-studio/MultiImageView","used":true,"who":"代码家"},{"_id":"58608596421aa9723a5a77ce","createdAt":"2016-12-26T10:51:02.683Z","desc":"Android HTML to TextView Builder 辅助工具库。","images":["http://img.gank.io/47df6353-9a3e-47e1-af56-9c36502720a5"],"publishedAt":"2016-12-26T11:40:05.242Z","source":"chrome","type":"Android","url":"https://github.com/jrummyapps/html-builder","used":true,"who":"代码家"},{"_id":"585b6f28421aa9723d29b98d","createdAt":"2016-12-22T14:14:00.935Z","desc":"Android上专为视屏直播打造的轻量级弹幕库（100多kb）","images":["http://img.gank.io/46af56ae-e5dd-414b-bb4d-3446fce5d8d2"],"publishedAt":"2016-12-23T11:41:19.908Z","source":"web","type":"Android","url":"https://github.com/hpdx/DanmukuLight","used":true,"who":"android_ls"},{"_id":"585b7213421aa9723a5a77ac","createdAt":"2016-12-22T14:26:27.638Z","desc":"一款 FlipBoard 翻页风格的 Gank.io 客户端","images":["http://img.gank.io/60632446-0486-4b27-be66-28cb09cf8440"],"publishedAt":"2016-12-23T11:41:19.908Z","source":"web","type":"Android","url":"https://github.com/yiyuanliu/FlipGank","used":true,"who":"Yiyuan Liu"},{"_id":"585b89d8421aa97240ef9f1a","createdAt":"2016-12-22T16:07:52.14Z","desc":"一个方便使用的跑马灯效果library","images":["http://img.gank.io/0934d64a-6ebb-4dc0-9c77-a69aaddeb8f3"],"publishedAt":"2016-12-23T11:41:19.908Z","source":"web","type":"Android","url":"https://github.com/gongwen/MarqueeViewDemo","used":true,"who":"龚文"},{"_id":"585c8fea421aa97240ef9f22","createdAt":"2016-12-23T10:46:02.158Z","desc":"Android 卡片滑动出现和消失效果，很好看哟。","images":["http://img.gank.io/6a6c4171-550e-41e3-b9ef-6cb013e904a6","http://img.gank.io/ac470892-4909-49e5-bdc6-24705eb6e497"],"publishedAt":"2016-12-23T11:41:19.908Z","source":"chrome","type":"Android","url":"https://github.com/mancj/SlideUp-Android","used":true,"who":"代码家"},{"_id":"585a44dd421aa97237bca8e3","createdAt":"2016-12-21T17:01:17.988Z","desc":"极速增量编译工具 Freeline 的超详细说明文档！","publishedAt":"2016-12-22T11:34:37.39Z","source":"chrome","type":"Android","url":"https://www.freelinebuild.com/docs/zh_cn/###","used":true,"who":"q"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean extends BaseBean{
    }


    public List<BaseBean> getGankList(){
        List<BaseBean> result = new ArrayList<>();
        result.addAll(results);
        return result;
    }
}
