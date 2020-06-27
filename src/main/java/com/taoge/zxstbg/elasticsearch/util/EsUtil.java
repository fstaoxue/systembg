package com.taoge.zxstbg.elasticsearch.util;

public class EsUtil {

//	private static EsUtil instance;
//
//	private static TransportClient client;
//
//	private EsUtil() {
//		this.client = getClient();
//	}
//
//	public static EsUtil getInstance(){
//		if(instance==null){
//			instance = new EsUtil();
//		}
//		return instance;
//	}
//
//
//	public static TransportClient getClient() {
//		if(client==null) {
//			try {
//				Settings settings = Settings.builder().put("cluster.name", "elasticsearch_cluster").put("client.transport.sniff", true).build();
//				TransportClient transportClient=new PreBuiltTransportClient(settings);
//				transportClient.addTransportAddress(new TransportAddress(InetAddress.getByName("162.168.2.46"), 24147));
//				client =transportClient;
//			} catch (Exception e) {
//				System.out.println("初始化es连接异常。。。。");
//				e.printStackTrace();
//			}
//		}
//		return client;
//	}
//
//	public static void closeClient(){
//		if(client!=null){
//			client.close();
//		}
//	}



//	public static void main(String[] args) throws Exception {
//		createIndex();

//		getClient();
//		ClusterState state = client.admin().cluster().prepareState().execute().actionGet().getState();
//		System.out.println(Arrays.asList(state.getMetaData().getConcreteAllIndices()));
//        closeClient();
//		SearchResponse response= EsUtil.getClient()
//				.prepareSearch("1_20180603_pb")
//				.setSize(10)
//				.get();
//		SearchHit[] hits=response.getHits().getHits();
//		for(int i=0;i<hits.length;i++){
//			SearchHit hit=hits[i];
//			System.out.println(hit.getId());
//			System.out.println(hit.getSourceAsString());
//			Map<String,Object> objs=hit.getSourceAsMap();
//			for(Map.Entry<String ,Object> entry:objs.entrySet()){
//				System.out.println(entry.getKey()+"-->"+entry.getValue());
//			}
//		}
//
//		System.out.println(response.toString());
//	}


}


