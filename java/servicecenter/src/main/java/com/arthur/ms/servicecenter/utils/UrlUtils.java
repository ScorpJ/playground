package com.arthur.ms.servicecenter.utils;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.StringTokenizer;

public class UrlUtils {


    public static String buildQueryString(String queryString) {

        if (queryString == null) {
            return "";
        }

        StringBuilder qsb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(queryString, "&");

        while (st.hasMoreTokens()) {

        }


        return qsb.toString();
    }


    public static void main(String[] args) throws Exception {
        System.out.println(URLEncoder.encode("GeographyValue LIKE '94101%'", "UTF-8"));
//        onlyData=true
//        q=CountryCode=US;GeographyType=%27POSTAL_CODE%27;GeographyValue%20LIKE%20%2794101%%27;PrimaryGeographyLevel2Flag=false
//        fields=GeographyValue,GeographyLevel2Value,GeographyLevel4Value
//        limit=25


        URI uri = new URI("https://fuscdrmsmc244-fa-ext.us.oracle.com:443");

        URI hcmURI = uri.resolve("/hcmRestApi/scim/Users");

        System.out.println(hcmURI.toString());



    }


}
