package pattern.publish.example2;

public class WaterQualifyPublish extends abstractPublish {

	private Integer status;

	@Override
	public void notifySub() {
		for (ISubScribe iSubScribe : subList) {
			// 开始根据污染级别判断是否需要通知，由这里总控
			if (this.status >= 0 && "监测人员".equals(iSubScribe.getJob())) {
				// 通知监测员做记录
				iSubScribe.update(this);
			}
			if (this.status >= 1 && "预警人员".equals(iSubScribe.getJob())) {
				// 通知预警人员
				iSubScribe.update(this);
			}
			if (this.status >= 2 && "监测部门领导".equals(iSubScribe.getJob())) {
				iSubScribe.update(this);
			}

		}

	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
		if (status >=0) {
			notifySub();
		}
	}

}
