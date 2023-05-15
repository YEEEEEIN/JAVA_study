package kopo23.domain;

public class WifiItem { // 도메인 리스트를 만들 예정 => 행 파일 이름, 나이, 전화번호, 주민번호
	private int id; // 번호
	private String InstallationLocationName; // 설치장소명
	private String InstallationLocationDetails; // 설치장소상세
	private String InstallationCityName; // 설치시도명
	private String InstallationDistrictName; // 설치시군구명
	private String InstallationFacilityType; // 설치시설구분
	private String ServiceProviderName; // 서비스제공사명
	private String WifiSsid; // 와이파이SSID
	private String DateOfInstallation; // 설치연월
	private String RoadNameAddress; // 소재지도로명주소
	private String LotNumberAddress; // 소재지지번주소
	private String ManagementAgencyName; // 관리기관명
	private String ManagementAgencyPhoneNumber; // 관리기관전화번호
	private double Latitude; // 위도
	private double Longitude; // 경도
	private String Created; // 데이터기준일자

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInstallationLocationName() {
		return InstallationLocationName;
	}

	public void setInstallationLocationName(String installationLocationName) {
		InstallationLocationName = installationLocationName;
	}

	public String getInstallationLocationDetails() {
		return InstallationLocationDetails;
	}

	public void setInstallationLocationDetails(String installationLocationDetails) {
		InstallationLocationDetails = installationLocationDetails;
	}

	public String getInstallationCityName() {
		return InstallationCityName;
	}

	public void setInstallationCityName(String installationCityName) {
		InstallationCityName = installationCityName;
	}

	public String getInstallationDistrictName() {
		return InstallationDistrictName;
	}

	public void setInstallationDistrictName(String installationDistrictName) {
		InstallationDistrictName = installationDistrictName;
	}

	public String getInstallationFacilityType() {
		return InstallationFacilityType;
	}

	public void setInstallationFacilityType(String installationFacilityType) {
		InstallationFacilityType = installationFacilityType;
	}

	public String getServiceProviderName() {
		return ServiceProviderName;
	}

	public void setServiceProviderName(String serviceProviderName) {
		ServiceProviderName = serviceProviderName;
	}

	public String getWifiSsid() {
		return WifiSsid;
	}

	public void setWifiSsid(String wifiSsid) {
		WifiSsid = wifiSsid;
	}

	public String getDateOfInstallation() {
		return DateOfInstallation;
	}

	public void setDateOfInstallation(String dateOfInstallation) {
		DateOfInstallation = dateOfInstallation;
	}

	public String getRoadNameAddress() {
		return RoadNameAddress;
	}

	public void setRoadNameAddress(String roadNameAddress) {
		RoadNameAddress = roadNameAddress;
	}

	public String getLotNumberAddress() {
		return LotNumberAddress;
	}

	public void setLotNumberAddress(String lotNumberAddress) {
		LotNumberAddress = lotNumberAddress;
	}

	public String getManagementAgencyName() {
		return ManagementAgencyName;
	}

	public void setManagementAgencyName(String managementAgencyName) {
		ManagementAgencyName = managementAgencyName;
	}

	public String getManagementAgencyPhoneNumber() {
		return ManagementAgencyPhoneNumber;
	}

	public void setManagementAgencyPhoneNumber(String managementAgencyPhoneNumber) {
		ManagementAgencyPhoneNumber = managementAgencyPhoneNumber;
	}

	public double getLatitude() {
		return Latitude;
	}

	public void setLatitude(double latitude) {
		Latitude = latitude;
	}

	public double getLongitude() {
		return Longitude;
	}

	public void setLongitude(double longitude) {
		Longitude = longitude;
	}

	public String getCreated() {
		return Created;
	}

	public void setCreated(String created) {
		Created = created;
	}

}
