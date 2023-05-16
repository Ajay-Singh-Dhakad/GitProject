package Test_Cases;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.RestAPI_Base.BaseClass;

import Utility.Authentication;
import Utility.FileCreate;
import Utility.createURL;
import Utility.payloadconverter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Github_Project {
public static String endpoint;
public static String token=Authentication.Accesstoken();
public static Response response;
public  static String full_name;
public  static String name;
public  static ArrayList <String> namess;
public  static String sha;
public  static Integer id;
public  static FileCreate filecreate = new FileCreate();
@Test(priority = 0,enabled = false)
public static void createRepo() throws IOException {
	endpoint=createURL.getbaseuri("/user/repos");
	String payloadBody=payloadconverter.generatepayload("createRepo.json");
	response=BaseClass.PostRequest(endpoint, payloadBody,token);
	String responsebody=response.getBody().asString();
	Assert.assertEquals(response.statusCode(),201);
	JsonPath js = new JsonPath(responsebody);
	full_name = js.get("full_name");
	System.out.println(responsebody);
}
@Test(priority = 1,enabled = false)
public static void getRepo() throws IOException {
	endpoint=createURL.getbaseuri("/repos/"+full_name);
	response=BaseClass.GetRequest(endpoint,token);
	String responsebody=response.getBody().asString();
	Assert.assertEquals(response.statusCode(),200);
	System.out.println(responsebody);
}

@Test(priority = 2,enabled = false)
public static void updateRepo() throws IOException {
	endpoint=createURL.getbaseuri("/repos/"+full_name);
	String payloadBody=payloadconverter.generatepayload("UpdateRepo.json");
	response=BaseClass.PatchRequest(endpoint,payloadBody,token);
	String responsebody=response.getBody().asString();
	JsonPath js = new JsonPath(responsebody);
	full_name=js.get("full_name");
	name=js.get("owner.login");
	System.out.println(name);
	Assert.assertEquals(response.statusCode(),200);
	System.out.println(responsebody);
}
@Test(priority = 3)
public static void ListRepo() throws IOException {
	endpoint=createURL.getbaseuri("/users/"+name+"/repos");
	response=BaseClass.GetRequest(endpoint,token);
	String responsebody=response.getBody().asString();
	Assert.assertEquals(response.statusCode(),200);
	System.out.println(responsebody);
}
@Test(priority = 4,enabled = false)
public static void ListRepoLanguage() throws IOException {
	endpoint=createURL.getbaseuri("/repos/"+full_name+"/languages");
	response=BaseClass.GetRequest(endpoint,token);
	String responsebody=response.getBody().asString();
	Assert.assertEquals(response.statusCode(),200);
	System.out.println(responsebody);
}
@Test(priority = 5)
public static void ListpublicRepo() throws IOException {
	endpoint=createURL.getbaseuri("/repositories");
	response=BaseClass.GetRequest(endpoint,token);
	String responsebody=response.getBody().asString();
	Assert.assertEquals(response.statusCode(),200);
	System.out.println(response.statusCode());
	System.out.println(responsebody);
}
@Test(priority = 6,enabled = false)
public static void ListRepoTags() throws IOException {
	endpoint=createURL.getbaseuri("/repos/"+full_name+"/tags");
	response=BaseClass.GetRequest(endpoint,token);
	String responsebody=response.getBody().asString();
	Assert.assertEquals(response.statusCode(),200);
	System.out.println(responsebody);
}
@Test(priority = 7,enabled = false)
public static void createAutolinks() throws IOException {
	endpoint=createURL.getbaseuri("/repos/"+full_name+"/autolinks");
	String payloadBody=payloadconverter.generatepayload("Autolinks.json");
	response=BaseClass.PostRequest(endpoint, payloadBody,token);
	String responsebody=response.getBody().asString();
	Assert.assertEquals(response.statusCode(),201);
	JsonPath js = new JsonPath(responsebody);
	id = js.get("id");
	System.out.println(responsebody);
}
@Test(priority = 8,enabled = false)
public static void getanAutolinks() throws IOException {
	endpoint=createURL.getbaseuri("/repos/"+full_name+"/autolinks/"+id);
	response=BaseClass.GetRequest(endpoint,token);
	String responsebody=response.getBody().asString();
	Assert.assertEquals(response.statusCode(),200);
	System.out.println(responsebody);
}
@Test(priority = 9,enabled = false)
public static void deleteanAutolinks() throws IOException {
	endpoint=createURL.getbaseuri("/repos/"+full_name+"/autolinks/"+id);
	response=BaseClass.DeleteRequestWithout_Payload(endpoint,token);
	String responsebody=response.getBody().asString();
	Assert.assertEquals(response.statusCode(),204);
	System.out.println(responsebody);
}
@Test(priority = 10,enabled = false)
public static void getAllrepoTopics() throws IOException {
	endpoint=createURL.getbaseuri("/repos/"+full_name+"/topics");
	response=BaseClass.GetRequest(endpoint,token);
	String responsebody=response.getBody().asString();
	JsonPath js=new JsonPath(responsebody);
	 namess = js.get("names");
	System.out.println(namess);
	Assert.assertEquals(response.statusCode(),200);
	System.out.println(responsebody);
}
@Test(priority = 11,enabled=false)
public static void replaceAllrepoTopics() throws IOException {
	endpoint=createURL.getbaseuri("/repos/"+full_name+"/topics");
	String payloadBody=payloadconverter.generatepayload("replaceallTopics.json");
	response=BaseClass.PutRequest(endpoint,payloadBody,token);
	String responsebody=response.getBody().asString();
	Assert.assertEquals(response.statusCode(),200);
	System.out.println(responsebody);
}
@Test(priority = 12,enabled = false)
public void createFile() throws IOException {
	endpoint = createURL.getbaseuri("/repos/"+full_name+"/contents/Somefile");
	String payloadbody = payloadconverter.generatepayload("CreateFile.json");
	response = BaseClass.PutRequest(endpoint, payloadbody , token);
	String responsebody=response.getBody().asString();
	JsonPath js = new JsonPath(responsebody);
	sha = js.get("content.sha");
	Assert.assertEquals(response.statusCode(), 201);
	System.out.println(responsebody);
}
@Test(priority = 13,enabled = false)
public static void createfork() throws IOException {
	endpoint=createURL.getbaseuri("/repos/"+full_name+"/forks");
	String payloadBody=payloadconverter.generatepayload("createForks.json");
	response=BaseClass.PostRequest(endpoint, payloadBody,token);
	String responsebody=response.getBody().asString();
	Assert.assertEquals(response.statusCode(),202);
	System.out.println(responsebody);
}
@Test(priority = 14,enabled = false)
public static void getforklist() throws IOException {
	endpoint=createURL.getbaseuri("/repos/"+full_name+"/forks");
	response=BaseClass.GetRequest(endpoint,token);
	String responsebody=response.getBody().asString();
	Assert.assertEquals(response.statusCode(),200);
	System.out.println(responsebody);
}
@Test(priority = 15,enabled = false)
public void deleteFile() throws IOException {
	filecreate.setMessage("deleting file");
	filecreate.setSha(sha);
	endpoint = createURL.getbaseuri("/repos/"+full_name+"/contents/Somefile");
	response = BaseClass.DeleteRequestWithPayload(endpoint, filecreate.toString(), token);
	String responsebody=response.getBody().asString();
	JsonPath js = new JsonPath(responsebody);
	Assert.assertEquals(response.statusCode(), 200);
	System.out.println(responsebody);
}
@Test(priority =16,enabled = false)
public static void deleteRepo() throws IOException {
	endpoint=createURL.getbaseuri("/repos/"+full_name);
	response=BaseClass.DeleteRequestWithout_Payload(endpoint,token);
	String responsebody=response.getBody().asString();
	Assert.assertEquals(response.statusCode(),204);
	System.out.println(responsebody);
}
}
