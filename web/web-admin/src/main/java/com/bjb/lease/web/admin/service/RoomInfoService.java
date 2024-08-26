package com.bjb.lease.web.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjb.lease.model.entity.RoomInfo;
import com.bjb.lease.web.admin.vo.apartment.ApartmentItemVo;
import com.bjb.lease.web.admin.vo.room.RoomDetailVo;
import com.bjb.lease.web.admin.vo.room.RoomItemVo;
import com.bjb.lease.web.admin.vo.room.RoomQueryVo;
import com.bjb.lease.web.admin.vo.room.RoomSubmitVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author liubo
* @description 针对表【room_info(房间信息表)】的数据库操作Service
* @createDate 2023-07-24 15:48:00
*/
public interface RoomInfoService extends IService<RoomInfo> {

    void saveOrUpdateRoom(RoomSubmitVo roomSubmitVo);

    IPage<RoomItemVo> pageRoomItemByQuery(Page<RoomItemVo> page, RoomQueryVo queryVo);

    RoomDetailVo getRoomDetailById(Long id);

    void removeRoomById(Long id);
}
