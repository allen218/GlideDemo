package com.dongnao.dnglide2.glide2.load.model;

import com.dongnao.dnglide2.glide2.cache.Key;
import com.dongnao.dnglide2.glide2.load.model.data.DataFetcher;

/**
 * Created by Administrator on 2018/5/7.
 */

public interface ModelLoader<Model, Data> {

    interface ModelLoaderFactory<Model, Data> {
        ModelLoader<Model, Data> build(ModelLoaderRegistry registry);
    }

    class LoadData<Data> {
        //缓存的key
        public final Key key;
        //加载数据
        public final DataFetcher<Data> fetcher;

        public LoadData(Key key, DataFetcher<Data> fetcher) {
            this.key = key;
            this.fetcher = fetcher;
        }
    }

    /**
     * 此Loader是否能够处理对应Model的数据
     *
     * @param model
     * @return
     */
    boolean handles(Model model);

    /**
     * 创建加载数据
     *
     * @param model
     * @return
     */
    LoadData<Data> buildData(Model model);
}
