//import com.Bootcamp.TwitterBasic.TwitterActions;
//import org.junit.Assert;
//import org.junit.Test;
//import org.mockito.Mockito;
//import twitter4j.Status;
//import twitter4j.Twitter;
//
//import javax.ws.rs.core.Response;
//
//import java.util.List;
//
//import static junit.framework.TestCase.assertEquals;
//import static junit.framework.TestCase.assertTrue;
//import static org.hamcrest.MatcherAssert.assertThat;
//
//public class TwitterTest {
//    Twitter twitter = Mockito.mock(Twitter.class);
//
//    @Test
//    public void testPostingTweet()throws Exception
//    {
//        /*//assertTrue(twitterActions.tweet("vanakkam") == "'code' : 201, 'message' : Created");
//        String twt = "asdf";
//        Status status = Mockito.mock(Status.class);
//        Mockito.doReturn(status).when(twitter).updateStatus(twt);
//
//        TwitterActions twitterActions = new TwitterActions(twitter);
//        Response response = twitterActions.tweet(twt);
//        Assert.assertEquals(response.getEntity(), null);*/
//
//
//    }
//
//    @Test
//    public void testGettingTime()throws Exception
//    {
//        List<Status> tweets = null;
//        Mockito.doReturn(tweets).when(twitter).getHomeTimeline();
//
//        TwitterActions twitterActions = new TwitterActions(twitter);
//        Response response = twitterActions.timeline();
//        Assert.assertEquals(response.getEntity(), tweets);
//    }
//}
