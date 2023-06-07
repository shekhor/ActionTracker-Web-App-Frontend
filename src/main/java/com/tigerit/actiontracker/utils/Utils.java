package com.tigerit.actiontracker.utils;




import com.tigerit.actiontracker.model.response.auth.AuthResponse;
import org.springframework.security.core.Authentication;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static com.tigerit.actiontracker.utils.CookieConstants.*;
import static com.tigerit.actiontracker.utils.CookieConstants.TOKEN_VALIDITY_IN_SECONDS;

public class Utils {

    public static boolean isEmpty(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(List<String> str) {
        if (str == null || str.size() <= 0) {
            return true;
        }
        return false;
    }

    public static boolean isNull(Object obj) {
        if (obj == null) {
            return true;
        }
        return false;
    }

    public static boolean isNull(Integer integer) {
        if (integer == null || integer.intValue() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNull(Long value) {
        if (value == null || value.longValue() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNull(BigDecimal number) {
        if (number == null || number.equals(new BigDecimal(0))) {
            return true;
        }
        return false;
    }

    public static boolean isNull(byte[] byteData) {
        if (byteData == null || byteData.length == 0) {
            return true;
        }
        return false;
    }

    public static Long convertStringToLongOb(String str) {
        try {
            Long longVal = Long.valueOf(str);
            return longVal;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static Integer convertStringToIntegerOb(String str) {
        try {
            Integer intVal = Integer.valueOf(str);
            return intVal;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static List<String> getEnumValues(Class<? extends Enum<?>> enumType) {
        return Arrays.stream(enumType.getEnumConstants()).map(Enum::name).collect(Collectors.toList());
    }



    public static Object getSessionObject(String objectName, HttpServletRequest request) {
        try {
            Object obj = new Object();
            HttpSession session;
            session = request.getSession(false);
            obj = session.getAttribute(objectName);
            return obj;
        } catch (Exception ex) {
            //ex.printStackTrace();
            return null;
        }
    }



    public static BufferedImage getBufferedImage(String filePath) {
        BufferedImage bImageFromConvert = null;
        try {
            FileInputStream fins = new FileInputStream(filePath);
            BufferedImage in = ImageIO.read(fins);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(in, "jpg", baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            InputStream ins = new ByteArrayInputStream(imageInByte);
            bImageFromConvert = ImageIO.read(ins);
            ins.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return bImageFromConvert;
    }

    /*public static String htmlEscape(String value) {
        String tmp = "";
        if (value != null) {
            try {
                tmp = StringEscapeUtils.escapeHtml4(value);
            } catch (Exception e) {
            }
        }
        return tmp;
    }*/








    public static Date getSpecificDate(int differenceToday) {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, differenceToday);
        return cal.getTime();
    }

    public static String getYesterdayDateString() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(getSpecificDate(-1));
    }

    public static Map<String, String> getQueryMap(String query) {
        if (!"".equals(query)) {
            String[] params = query.split("&");
            Map<String, String> map = new HashMap<String, String>();
            for (String param : params) {
                if (param.split("=").length == 2) {
                    String name = param.split("=")[0];
                    String value = param.split("=")[1];
                    map.put(name, value);
                }
            }
            return map;
        }
        return new HashMap<String, String>();
    }







    public static int getCurrentYear() {
        Date date = new Date(); // your date
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            System.out.println("Year is --->> " + year);

            return year;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return 2017;
    }

    public static String formatDate(String date, String initDateFormat, String endDateFormat) {

        try {
            Date initDate = new SimpleDateFormat(initDateFormat).parse(date);
            SimpleDateFormat formatter = new SimpleDateFormat(endDateFormat);
            String parsedDate = formatter.format(initDate);

            return parsedDate;
        } catch (Exception ex) {

        }
        return date;
    }

    public static boolean isValidDate(String dateToValidate, String dateFromat){

        if(dateToValidate == null){
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);

        try {

            //if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);
            System.out.println(date);

        } catch (ParseException e) {

            e.printStackTrace();
            return false;
        }

        return true;
    }







    private  static boolean ifAllFieldsNull(Object obj) throws IllegalAccessException {
        for (Field field : obj.getClass().getDeclaredFields())
        {
            field.setAccessible(true);
            if (field.getType()!=boolean.class && !field.getType().isPrimitive() && field.get(obj)!= null)
            {
                if(field.getType()==String.class && field.get(obj).toString().length()>0)
                    return false;
            }
        }
        return true;
    }
/*
    private static  <T>  List<T> sanitizeUserDataList(Employee employee, List<T>list)
    {

        List<T> newList= new ArrayList<T>();
        if(list!=null && list.size()>0)
        {
            for(T obj: list)
            {
                try
                {
                    if(!ifAllFieldsNull(obj))
                    {
                        newList.add(obj);
                    }
                }
                catch (Exception e)
                {
                }
            }
        }

        return newList;
    }*/



    public static boolean ifMatchWithDefinedDegree(String educationLabel)
    {

       return educationLabel.equalsIgnoreCase("B.SC") || educationLabel.equalsIgnoreCase("BBA") || educationLabel.equalsIgnoreCase("LLB");

    }


    public static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap, final boolean order)
    {

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public static String redirectUrlwithError(String url, String error, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("error", error);
        return "redirect:" + url;
    }

    public static String redirectUrlwithSuccess(String url, String success, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("success", success);
        return "redirect:" + url;
    }

    public static void deleteCookie(HttpServletRequest request,HttpServletResponse response, String cookieName){
        Cookie cookie = WebUtils.getCookie(request, cookieName);
        if(cookie!= null && cookie.getValue() != null){
            cookie.setMaxAge(0);
            cookie.setValue(null);
            response.addCookie(cookie);
        }
    }
}
