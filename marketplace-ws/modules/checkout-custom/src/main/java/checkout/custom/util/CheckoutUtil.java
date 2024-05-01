package checkout.custom.util;

import checkout.custom.model.*;
import com.liferay.petra.string.StringPool;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public interface CheckoutUtil {

    static String dateConverter(Date inputDate) {

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime localDateTime = inputDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        return localDateTime.atZone(ZoneId.of("Asia/Kolkata")).format(outputFormatter);

    }

    static State getState(String stateCode, String stateName) {

        State state = new State();

        state.setStateCode(stateCode);
        state.setStateName(stateName);

        return state;

    }

    static LandlineDetails getLandlineDetails(String landlineCode, String landlineNumber) {

        LandlineDetails landlineDetails = new LandlineDetails();

        landlineDetails.setLandlineCode(landlineCode);
        landlineDetails.setLandlineNumber(landlineNumber);

        return landlineDetails;

    }

    static MobileNumber getMobileNumberDetails(String mobileCode, String mobileNo) {

        MobileNumber mobileNumber = new MobileNumber();

        mobileNumber.setMobileCode(mobileCode);
        mobileNumber.setMobileNumber(mobileNo);

        return mobileNumber;

    }

    static Country getCountry(String countryCode, String countryName) {

        Country country = new Country();

        country.setCountryCode(countryCode);
        country.setCountryName(countryName);

        return country;

    }

    static DistrictProvince getDistrictProvince(String districtProvinceCode, String districtProvinceName) {

        DistrictProvince districtProvince = new DistrictProvince();

        districtProvince.setDistrictProvinceCode(districtProvinceCode);
        districtProvince.setDistrictProvinceName(districtProvinceName);

        return districtProvince;

    }

    static List<Dates> getDates(String dateType, Date inputDate) {

        List<Dates> dates = new ArrayList<>();
        Dates date = new Dates();

        date.setDateType(dateType);
        date.setDateValue(StringPool.BLANK + dateConverter(inputDate));

        dates.add(date);

        return dates;

    }

    static int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    static ItemStandards getItemStandards(String itemStandardType, String itemStandardValue) {

        ItemStandards itemStandards = new ItemStandards();

        itemStandards.setStandardType(itemStandardType);
        itemStandards.setValue(itemStandardValue);

        return itemStandards;

    }

}
