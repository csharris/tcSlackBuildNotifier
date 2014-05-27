package slacknotifications.teamcity.extension.bean;

import slacknotifications.teamcity.payload.convertor.ExtraParametersMapToJsonConvertor;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;

public class ProjectSlackNotificationsBeanJsonSerialiser {
	
	public static String serialise(ProjectSlackNotificationsBean project){
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.registerConverter(new ExtraParametersMapToJsonConvertor());
        xstream.alias("projectSlacknotificationConfig", ProjectSlackNotificationsBean.class);
        /* For some reason, the items are coming back as "@name" and "@value"
         * so strip those out with a regex.
         */
		return xstream.toXML(project);
	}

}