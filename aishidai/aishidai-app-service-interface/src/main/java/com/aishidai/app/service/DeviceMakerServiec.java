package com.aishidai.app.service;

import java.util.List;

import com.aishidai.app.model.pojo.DeviceMakerDO;

public interface DeviceMakerServiec {

	List<DeviceMakerDO> selectByMakerId(Long id);

	List<DeviceMakerDO> selectBydeviceId(Long id);

}
