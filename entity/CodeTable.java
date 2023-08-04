
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "post")
public class CodeTable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "no")
	private Integer id;

	@Column(name = "jis_code")
	private String jisCode;

	@Column(name = "old_zip_code")
	private String oldZipCode;

	@Column(name = "zip_code")
	private String zipCode;

	@Column(name = "prefecture_name")
	private String prefectureName;

	@Column(name = "city_name")
	private String cityName;

	@Column(name = "town_name")
	private String townName;

	@Column(name = "prefecture_name_kana")
	private String prefectureNameKana;

	@Column(name = "city_name_kana")
	private String cityNameKana;

	@Column(name = "town_name_kana")
	private String townNameKana;

	public CodeTable() {
		super();
	}

	public CodeTable(String[] cmt) {
		super();

		this.jisCode = cmt[0];
		this.oldZipCode = cmt[1];
		this.zipCode = cmt[2];
		this.prefectureNameKana = cmt[3];
		this.cityNameKana = cmt[3];
		this.townNameKana = cmt[5];
		this.prefectureName = cmt[6];
		this.cityName = cmt[7];
		this.townName = cmt[8];
	}

	public Integer getId() {
		return id;
	}

	public String getJisCode() {
		return jisCode;
	}

	public String getOldZipCode() {
		return oldZipCode;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getPrefectureName() {
		return prefectureName;
	}

	public String getCityName() {
		return cityName;
	}

	public String getTownName() {
		return townName;
	}

	public String getPrefectureNameKana() {
		return prefectureNameKana;
	}

	public String getCityNameKana() {
		return cityNameKana;
	}

	public String getTownNameKana() {
		return townNameKana;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setJisCode(String jisCode) {
		this.jisCode = jisCode;
	}

	public void setOldZipCode(String oldZipCode) {
		this.oldZipCode = oldZipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setPrefectureName(String prefectureName) {
		this.prefectureName = prefectureName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public void setPrefectureNameKana(String prefectureNameKana) {
		this.prefectureNameKana = prefectureNameKana;
	}

	public void setCityNameKana(String cityNameKana) {
		this.cityNameKana = cityNameKana;
	}

	public void setTownNameKana(String townNameKana) {
		this.townNameKana = townNameKana;
	}

	public String nameOfPrefecturesKatakana() {
		String nameOfPrefecturesKatakana = getPrefectureNameKana() + getCityNameKana();
		return nameOfPrefecturesKatakana;
	}

	public String nameOfPrefecturesKanji() {
		String nameOfPrefecturesKanji = getPrefectureName() + getCityName();
		return nameOfPrefecturesKanji;
	}

}
