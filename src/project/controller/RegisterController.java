package project.controller;

import java.util.List;
import java.util.Map;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import sample.dto.TwitterDto;
import sample.model.Tweet;

public class RegisterController extends Controller {

    @Override
    protected Navigation run() throws Exception {        
      //Validators
        Validators v = new Validators(this.request);
        v.add("username", v.required(), v.minlength(8), v.maxlength(64));
        v.add("password", v.required(), v.minlength(8), v.maxlength(64));
        
        //IF inputs are valid
        if (v.validate()) {
            this.requestScope("errors", "");
            Map<String,Object> input = new RequestMap(this.request);
            TwitterDto tweetDto = new TwitterDto();
            BeanUtil.copy(input, tweetDto);
            service.tweet(tweetDto);
            return redirect(this.basePath);
        } else {
            StringBuffer errors = new StringBuffer("Errors: ");
            for (int i = 0; i < v.getErrors().size(); i++) {
                if(i > 0) {
                    errors.append(", ");
                }
                errors.append(v.getErrors().get(i));
            }
            this.requestScope("errors", errors.toString());
            //reload tweets
            List<Tweet> tweetList = service.getTweetList();
            requestScope("tweetList", tweetList);
            return forward("meal_management/index.jsp");
        }
    }

}
