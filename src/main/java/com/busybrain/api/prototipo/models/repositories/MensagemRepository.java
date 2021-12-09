package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.Mensagem;
import com.busybrain.api.prototipo.views.MensagemView;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MensagemRepository extends CrudRepository<Mensagem, Integer>{
    
    String queryToMessage = "select mensagens.message_content AS messageContent, users.user_name AS Username, grupos.group_name AS groupName " + 
    "from mensagem AS mensagens " + 
    "inner join utilizador_tarefa userstasks on userstasks.user_identifier = mensagens.message_user_id " + 
    "inner join utilizador users on users.user_id = userstasks.user_identifier " + 
    "inner join chat chats on chats.chat_id = mensagens.message_chat_id " + 
    "inner join grupo grupos on grupos.group_id = chats.chat_id ";
            
    @Query(value = queryToMessage + "where chats.chat_id=:chatid", nativeQuery = true)
    Iterable<MensagemView> findByChatid(@Param("chatid") int chatid); 

}
