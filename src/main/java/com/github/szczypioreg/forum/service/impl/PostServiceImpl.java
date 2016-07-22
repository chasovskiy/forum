/**
 * Created by Dawid Stankiewicz on 18.07.2016
 */
package com.github.szczypioreg.forum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.szczypioreg.forum.domain.Post;
import com.github.szczypioreg.forum.domain.Topic;
import com.github.szczypioreg.forum.domain.User;
import com.github.szczypioreg.forum.domain.repository.PostRepository;
import com.github.szczypioreg.forum.service.PostService;
import com.github.szczypioreg.forum.service.TopicService;

@Service
public class PostServiceImpl implements PostService {
    
    @Autowired
    private PostRepository postRepository;
    
    @Autowired
    private TopicService topicService;
    
    @Override
    public Post findOne(int id) {
        return postRepository.findOne(id);
    }
    
    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }
    
    @Override
    public List<Post> findRecent() {
        return findRecent(10);
    }
    
    @Override
    public List<Post> findRecent(int count) {
        // TODO
        return findAll();
    }
    
    @Override
    public List<Post> findByUser(User user) {
        return postRepository.findByUser(user);
    }
    
    @Override
    public List<Post> findByTopic(int idTopic) {
        return findByTopic(topicService.findOne(idTopic));
    }
    
    @Override
    public List<Post> findByTopic(Topic topic) {
        return postRepository.findByTopic(topic);
    }
    
    @Override
    public void save(Post post) {
        postRepository.save(post);
    }
    
    @Override
    public void delete(int id) {
        delete(findOne(id));
    }
    
    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }
    
}