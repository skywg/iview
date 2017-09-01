/*package com.ovit.bee.util;

import java.util.ArrayList;
import java.util.List;




public class TreeUtil {
	

	public <T> TreeUtil(List<T> list) {
		List<T> treeNodeList = new ArrayList<T>();
		for (T comment : list) { 
			if (null == comment.) {
				comment.setFpid("0");
			}
			treeNodeList.add(comment);
		}
	}

	public <T> List<T> createTreeList() {
		T root = generateTreeNode("0");
		return root.getList();
	}

	*//**
	 * 
	 * @param nodeId
	 * @return
	 *//*
	private <T> T getNodeById(String nodeId) {
		T treeNode = new T();
		for (T item : treeNodeList) {
			if (item.getFid() == nodeId) {
				treeNode = item;
				break;
			}
		}
		return treeNode;
	}

	*//**
	 * 
	 * @param nodeId
	 * @return
	 *//*
	private List<T> getChildrenNodeById(String nodeId) {
		List<T> childrenTreeNode = new ArrayList<T>();
		for (T item : treeNodeList) {
			if (item.getFid() == nodeId) {
				childrenTreeNode.add(item);
			}
		}
		return childrenTreeNode;
	}

	*//**
	 * 递归生成Tree结构数据
	 * 
	 * @param rootId
	 * @return
	 *//*
	private T generateTreeNode(String rootId) {
		T root = this.getNodeById(rootId);
		List<T> childrenTreeNode = this
				.getChildrenNodeById(rootId);
		for (T item : childrenTreeNode) {
			T node = this
					.generateTreeNode(item.getFid());
			if (null == root.getList()) {
				List<T> children = new ArrayList<T>();
				root.setList(children);
			}
			root.getList().add(node);
		}
		return root;
	}
}
*/