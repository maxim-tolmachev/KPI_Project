package vk;

public class VKInfo {
	private String accessToken;
	private long id;
	private final String[] filds={"id","access_token"};
	public VKInfo(String encodeddata){
		String[] params = encodeddata.split("&");
		for (int i = 0; i < params.length; i++) {
			for (int j = 0; j < filds.length; j++) {
				if(params[i].contains(filds[j])){
					switch (j) {
					case 0:
						setId(Long.valueOf(params[i].replace(filds[j]+"=", "").replace("user_", "")));
						break;
					case 1:
						setAccessToken(params[i].replace(filds[j]+"=", ""));
						break;

					default:
						break;
					}
				}
			}
		}
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "VKInfo [accessToken=" + accessToken + ", id=" + id + "]";
	}

}
