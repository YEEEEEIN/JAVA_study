package kopo23.domain;

public class WifiItem { // ������ ����Ʈ�� ���� ���� => �� ���� �̸�, ����, ��ȭ��ȣ, �ֹι�ȣ
	private int id; // ��ȣ
	private String InstallationLocationName; // ��ġ��Ҹ�
	private String InstallationLocationDetails; // ��ġ��һ�
	private String InstallationCityName; // ��ġ�õ���
	private String InstallationDistrictName; // ��ġ�ñ�����
	private String InstallationFacilityType; // ��ġ�ü�����
	private String ServiceProviderName; // �����������
	private String WifiSsid; // ��������SSID
	private String DateOfInstallation; // ��ġ����
	private String RoadNameAddress; // ���������θ��ּ�
	private String LotNumberAddress; // �����������ּ�
	private String ManagementAgencyName; // ���������
	private String ManagementAgencyPhoneNumber; // ���������ȭ��ȣ
	private double Latitude; // ����
	private double Longitude; // �浵
	private String Created; // �����ͱ�������

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
