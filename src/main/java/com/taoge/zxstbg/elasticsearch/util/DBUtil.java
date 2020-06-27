package com.taoge.zxstbg.elasticsearch.util;


public class DBUtil {

//    /** */
//    private static final Logger LOG = LoggerFactory.getLogger(DBUtil.class);
//
//
//    /*
//    *将结果集ResultSet转化为list
//     */
//    public static List<Map<String,Object>> resultSet2Map(ResultSet rs) throws SQLException {
//        if(rs.wasNull()){
//            return null;
//        }else {
//            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//            ResultSetMetaData md = rs.getMetaData();//获取键名
//            int columnCount = md.getColumnCount();//获取行的数量
//            while (rs.next()) {
//                Map rowData = new HashMap();//声明Map
//                for (int i = 1; i <= columnCount; i++) {
//                    rowData.put(md.getColumnName(i), rs.getObject(i));//获取键名及�??
//                }
//                list.add(rowData);
//            }
//            return list;
//        }
//    }
//
//    /*
//    hbase 的查询结果转换为ListMap
//    ResultScanner
//     */
//    public static List<Map<String,String>> resultScanner2Map(ResultScanner resultScanner) {
//        if(resultScanner.iterator().hasNext()){
//            return null;
//        }else {
//            List<Map<String, String>> list = new ArrayList<Map<String, String>>();
//
//            for (Iterator<Result> it = resultScanner.iterator(); it.hasNext(); ) {
//                Result result = it.next();
//                Map rowData = result2Map(result);
//                list.add(rowData);
//            }
//            return list;
//        }
//    }
//    public static Map<String,String> result2Map(Result result){
//        if(result==null){
//            return null;
//        }else {
//            Map rowData = new HashMap();
//            rowData.put("id", Bytes.toString(result.getRow()));
//            NavigableMap<byte[], NavigableMap<byte[], byte[]>> familyMap = result.getNoVersionMap();
//            for (NavigableMap.Entry<byte[], NavigableMap<byte[], byte[]>> entry : result.getNoVersionMap().entrySet()) {
//                NavigableMap<byte[], byte[]> valueMap = entry.getValue();
//                for (Map.Entry<byte[], byte[]> entry1 : valueMap.entrySet()) {
//                    rowData.put(Bytes.toString(entry.getKey()) + ":" + Bytes.toString(entry1.getKey()), Bytes.toString(entry1.getValue()));
//                }
//            }
//
//            return rowData;
//        }
//    }


}
