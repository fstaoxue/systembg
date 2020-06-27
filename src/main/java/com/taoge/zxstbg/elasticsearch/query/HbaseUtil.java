package com.taoge.zxstbg.elasticsearch.query;

public class HbaseUtil {


//	/**hbase连接配置*/
//	public static final String ZOOKEEPER_QUORUM_NUM = "162.168.2.46,162.168.2.47,162.168.2.48";
//	public static final String ZOOKEEPER_CLIENT_PORT_NUM = "24002";
//	private static String ZK_IPS = ZOOKEEPER_QUORUM_NUM;
//	private static String ZK_PORT =ZOOKEEPER_CLIENT_PORT_NUM;
//
//	private static Connection con;
//	private static Configuration configuration = null;
//	private String kerberosUserName = null;
//
//	public static void init() {
//
////		try {
//////			Configuration config = HBaseConfiguration.create();
//////			config.set("hbase.zookeeper.quorum", ZK_IPS);
//////			config.set("hbase.zookeeper.property.clientPort", ZK_PORT);
////			configuration = HBaseConfiguration.create();
////			configuration.addResource(new Path(getClass().getResource("/config/core-site.xml").getFile()));
////			configuration.addResource(new Path(getClass().getResource("/config/hdfs-site.xml").getFile()));
////			configuration.addResource(new Path(getClass().getResource("/config/hbase-site.xml").getFile()));
////
////			con = ConnectionFactory.createConnection(Configuration);
////			System.out.println("Hbase初始化连接成功！");
////		} catch (IOException e) {
////			System.out.println("Hbase初始化连接失败！");
////			e.printStackTrace();
////		}
//	}
//
//	private void login() throws IOException {
////		String krb5File = null;
////		String userKeytabFile = null;
////		if (User.isHBaseSecurityEnabled(configuration)) {
////			userKeytabFile = new File(getClass().getResource("/config/usermanage.keytab").getFile()).getPath();
////			krb5File = new File(getClass().getResource("/config/krb5.conf").getFile()).getPath();
////
////			/*
////			 * if need to connect zk, please provide jaas info about zk. of course,
////			 * you can do it as below:
////			 * System.setProperty("java.security.auth.login.config", confDirPath +
////			 * "jaas.conf"); but the demo can help you more : Note: if this process
////			 * will connect more than one zk cluster, the demo may be not proper. you
////			 * can contact us for more help
////			 */
////
////			//LoginUtil.setJaasConf(Constants.ZOOKEEPER_DEFAULT_LOGIN_CONTEXT_NAME, kerberosUserName, userKeytabFile);
////			LoginUtil.setJaasFile( kerberosUserName, userKeytabFile);
////			LoginUtil.setKrb5Config(krb5File);
////			LoginUtil.setZookeeperServerPrincipal(Constants.ZOOKEEPER_SERVER_PRINCIPAL_KEY,
////					Constants.ZOOKEEPER_DEFAULT_SERVER_PRINCIPAL);
////			LoginUtil.login(kerberosUserName, userKeytabFile, krb5File, configuration);
////		}
//	}
//
//	public static Connection getConnection() {
//		if (con == null) {
//			init();
//		}
//
//		return con;
//	}
//
//	@Test
//	public void test() throws Exception {
//		File file = new File(ClassLoader.getSystemResource("algorithm-db.xml").getFile()) ;
//		DBFactory.init(file) ;
//		HbaseDBHandlerImpl dbHandler = (HbaseDBHandlerImpl) DBFactory.create("hbase") ;
//		con=dbHandler.getConnection();
//		Table table = null;
//		try {
//			init();
//			System.out.println(con);
//
//			table = con.getTable(TableName.valueOf("1_20180603_pb"));
//			Get get = new Get(Bytes.toBytes("wwgq9r8_1527977920_02_冀R499V9"));
//			Result result = table.get(get);
//			Map<String, String>map=DBUtil.result2Map(result);
//			System.out.println(map);
//			System.out.println("打印结果");
//			for (Entry<String, String> entry : map.entrySet()) {
//				String key = entry.getKey();
//				String value = entry.getValue();
//
//				System.out.println(key + " " + value);
//			}
//			con.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			IOUtils.closeQuietly(table);
//			IOUtils.closeQuietly(con);
//		}
//
//
//
//
//	}
//
//	public static Map<String, Object> getByRowKey(String table_name, String family, String rowKey) {
//
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		Table table = null;
//		try {
//
//			table = getConnection().getTable(TableName.valueOf(table_name));
//			Get get = new Get(Bytes.toBytes(rowKey));
//			get.addFamily(family.getBytes());
//			Result result = table.get(get);
//			NavigableMap<byte[], byte[]> familyMap = result.getFamilyMap(family.getBytes());
//			for (Entry<byte[], byte[]> entry : familyMap.entrySet()) {
//				byte[] key = entry.getKey();
//				byte[] value = entry.getValue();
//
//				resultMap.put(Bytes.toString(key), Bytes.toString(value));
//			}
//
//		} catch (Exception e) {
//			IOUtils.closeQuietly(table);
//			IOUtils.closeQuietly(con);
//			System.out.println("Hbase 查询失败");
//			e.printStackTrace();
//		} finally {
//
//		}
//
//		return resultMap;
//	}

}
