public class CBRequestBuilder {

    private final String dateFrom;
    private final String dateTo;

    public CBRequestBuilder(String dateFrom, String dateTo ){
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public String getPageDoc ()  {
        return String.format("https://www.cbr.ru/scripts/XML_dynamic" +
                ".asp?date_req1=%s&date_req2=%s&VAL_NM_RQ=R01235", this.dateFrom, this.dateTo);
    }

    // с какой даты
    // по какую
    // и код валюты

    // метод возвращающий string url
}
