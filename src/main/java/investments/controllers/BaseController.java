package investments.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController
{
    protected static Logger log;
    
    public BaseController()
    {
        log = LoggerFactory.getLogger(this.getClass());
    }    
}