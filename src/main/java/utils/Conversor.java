package utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Conversor de tipos SQL <-> java.time
 * @author xaime
 */
public class Conversor {
    
    
    public LocalDateTime convTimestamp2LocalDateTime(Timestamp timestamp) {
        
        if (timestamp == null) {
            
            return null;
            
        } else {
            
            return timestamp.toLocalDateTime();
            
        }
        
    }
    
}
