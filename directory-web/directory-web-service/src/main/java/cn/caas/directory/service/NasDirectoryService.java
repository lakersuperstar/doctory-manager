package cn.caas.directory.service;

import java.util.List;

import cn.caas.directory.domain.NasFileVO;

/**
 * 获取nasfile服务接口
 * 
 * @author songk
 *
 */
public interface NasDirectoryService {

	/**
	 * 返回展示的树形服务
	 * 
	 * @param path
	 * @return
	 */
	public List<NasFileVO> getChildFilePathVO(String path, String baseId);

}
