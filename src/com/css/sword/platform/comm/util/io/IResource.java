package com.css.sword.platform.comm.util.io;


/**
 * <p>Title: </p>
 * <p>Description:  * Interface for a resource descriptor that abstracts from the actual
 * type of resource, like file or class path resource.
 *
 * <p>An InputStream can be opened for every resource if it exists in
 * physical form, but a URL or File handle can just be returned for
 * certain resources. The actual behavior is implementation-specific.</p>
 *
 * <p>Copyright: Copyright (c) 2004 中软网络??术股份有限公??</p>
 * <p>Company: 应用产品研发中心</p>
 * @author wwq
 * @version 1.0
 */

import java.io.File;
import java.io.IOException;
import java.net.URL;


public interface IResource extends IInputStreamSource {

    /**
     * Return whether this resource actually exists in physical form.
     */
    boolean exists();

    /**
     * Return whether this resource represents a handle with an open
     * stream. If true, the InputStream cannot be read multiple times,
     * and must be read and closed to avoid resource leaks.
     * <p>Will be false for all usual resource descriptors.
     */
    boolean isOpen();

    /**
     * Return a URL handle for this resource.
     * @throws IOException if the resource cannot be resolved as URL,
     * i.e. if the resource is not available as descriptor
     */
    URL getURL() throws IOException;

    /**
     * Return a File handle for this resource.
     * @throws IOException if the resource cannot be resolved as absolute
     * file path, i.e. if the resource is not available in a file system
     */
    File getFile() throws IOException;

    /**
     * Return a description for this resource,
     * to be used for error output when working with the resource.
     * <p>Implementations are also encouraged to return this value
     * from their toString method.
     * @see java.lang.Object#toString
     */
    String getDescription();

}