package cn.caas.directory.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.caas.directory.domain.NasFileVO;
import cn.caas.directory.service.NasDirectoryService;
import cn.caas.directory.util.FileUtil;

public class NasDirectoryServiceImpl implements NasDirectoryService {

	private static Logger logger = LoggerFactory
			.getLogger(NasDirectoryServiceImpl.class);

	/**
	 * 基本目录列表
	 */
	private List<String> basePaths;

	@Override
	public List<NasFileVO> getChildFilePathVO(String path, String baseId) {
		logger.info("获取path：" + path);
		// null 返回基本的nas根目录
		if (StringUtils.isEmpty(path)) {
			List<NasFileVO> nasFileVOs = new ArrayList<NasFileVO>();
			if (basePaths != null && basePaths.size() > 0) {
				int id = 1;
				for (String basePath : basePaths) {
					int index = basePath.lastIndexOf("//");
					String baseName = basePath.substring(index + 1);
					NasFileVO nasfile = new NasFileVO();
					nasfile.setFullName(basePath);
					nasfile.setIsParent("true");
					nasfile.setName(baseName);
					nasfile.setId(id + "");
					id++;
					nasFileVOs.add(nasfile);
				}
			}
			return nasFileVOs;
		}

		if (baseId.isEmpty()) {
			baseId = this.getBaseId(path);
		}
		if (!path.endsWith("/")) {
			path = path + "/";
		}
		String[] childFileNames = FileUtil.getChildFileName(path);
		if (childFileNames == null) {
			return null;
		}
		List<NasFileVO> filePaths = new ArrayList<NasFileVO>();

		int i = 1;
		for (String childFileName : childFileNames) {
			NasFileVO nasFileVO = new NasFileVO();
			nasFileVO.setName(childFileName);
			nasFileVO.setId(baseId + "" + i);
			String filePath = path + "/" + childFileName;
			nasFileVO.setFullName(filePath);
			nasFileVO.setIsParent(FileUtil.isDirectory(filePath) + "");
			filePaths.add(nasFileVO);
			i++;
		}
		return filePaths;
	}

	private String getBaseId(String path) {
		String[] paths = path.split("//");
		String baseIds = "1";
		for (int i = 0; i < paths.length; i++) {
			baseIds = baseIds + "" + 1;
		}
		return baseIds;
	}

	public List<String> getBasePaths() {
		return basePaths;
	}

	public void setBasePaths(List<String> basePaths) {
		this.basePaths = basePaths;
	}

}
