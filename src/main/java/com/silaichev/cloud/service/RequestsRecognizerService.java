package com.silaichev.cloud.service;

import com.silaichev.cloud.entity.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestsRecognizerService {

    @Autowired
    private InfoService infoService;

    private static final String CREATING_PATTERN = "create";

    private static final String DELETING_PATTERN = "delete";

    private static final String BACKUP_PATTERN = "backup";

    private static final String EDIT_PATTERN = "edit";

    public String createInfoMessage(Info info) {
        return CREATING_PATTERN + infoService.convertToString(info);
    }

    public String deleteMessage(Info info) {
        return DELETING_PATTERN + infoService.convertToString(info);
    }

    public String backupMessage() {
        StringBuilder stringBuilder = new StringBuilder(BACKUP_PATTERN);
        infoService.getAllInfo().forEach(info -> stringBuilder.append(infoService.convertToString(info)));
        return stringBuilder.toString();
    }

    public String editMessage(Info[] infos) {
        StringBuilder stringBuilder = new StringBuilder(EDIT_PATTERN);
        stringBuilder.append(infoService.convertToString(infos[0]))
                .append(infoService.convertToString(infos[1]));
        return stringBuilder.toString();
    }
}
