package org.lpw.ranch.weixin;

import org.lpw.tephra.dao.orm.PageList;
import org.lpw.tephra.dao.orm.lite.LiteOrm;
import org.lpw.tephra.dao.orm.lite.LiteQuery;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

/**
 * @author lpw
 */
@Repository(WeixinModel.NAME + ".dao")
class WeixinDaoImpl implements WeixinDao {
    @Inject
    private LiteOrm liteOrm;

    @Override
    public PageList<WeixinModel> query() {
        return liteOrm.query(new LiteQuery(WeixinModel.class), null);
    }

    @Override
    public WeixinModel findByKey(String key) {
        return liteOrm.findOne(new LiteQuery(WeixinModel.class).where("c_key=?"), new Object[]{key});
    }

    @Override
    public WeixinModel findByAppId(String appId) {
        return liteOrm.findOne(new LiteQuery(WeixinModel.class).where("c_app_id=?"), new Object[]{appId});
    }

    @Override
    public void save(WeixinModel weixin) {
        liteOrm.save(weixin);
    }

    @Override
    public void delete(String id) {
        liteOrm.deleteById(WeixinModel.class, id);
    }
}
