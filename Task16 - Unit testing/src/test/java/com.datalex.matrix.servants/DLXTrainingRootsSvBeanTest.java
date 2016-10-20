package com.datalex.matrix.servants;

import com.datalex.cbp.rqrs.CBPSvRSBase;
import com.datalex.mw.bean.BeanFactory;
import com.datalex.rqrs.reservation.ItinerarySegment;
import com.datalex.rqrs.reservation.ItinerarySegmentLink;
import com.datalex.rqrs.reservation.Reservation;
import com.datalex.rqrs.reservation.training.DLXTrainingRootsSvRQ;
import com.datalex.rqrs.reservation.training.DLXTrainingRootsSvRS;
import com.datalex.tests.DatalexTest;
import com.datalex.tests.TestUtils;
import com.datalex.tests.bean.UnitTestHelper;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.fail;

/**
 * Unit testing class for DLXTrainingRootsSvBean.
 *
 * @author Maksim Ruts
 */
public class DLXTrainingRootsSvBeanTest extends DatalexTest
{

    /** project number */
    private static final String PROJECT_NUMBER = "00010002";

    /** training servant bean */
    private DLXTrainingRootsSvBean m_dlxTrainingRootsSvBean;

    /** empty request file name */
    private static final String EMPTY_REQUEST_FILE = "EmptyRequest.xml";

    /** empty request instance */
    private DLXTrainingRootsSvRQ m_emptyRequest = null;

    /** valid request file name */
    private static final String VALID_REQUEST_FILE = "ValidRequest.xml";

    /** valid request instance */
    private DLXTrainingRootsSvRQ m_validRequest = null;

    /**
     * Sets up any variables etc.
     *
     * @throws Exception throws an exception on error
     */
    @Before
    public void setUp() throws Exception
    {
        super.setUp();
        final UnitTestHelper unitTestHelper = getUnitTestHelper();

        m_dlxTrainingRootsSvBean = (DLXTrainingRootsSvBean) BeanFactory.create("Bean", "DLXTrainingRootsSv");

        String filename = unitTestHelper.getCannedFilesDirectory() + File.separator + EMPTY_REQUEST_FILE;
        m_emptyRequest = (DLXTrainingRootsSvRQ) TestUtils.getXMLObject(filename, DLXTrainingRootsSvRQ.class);

        filename = unitTestHelper.getCannedFilesDirectory() + File.separator + VALID_REQUEST_FILE;
        m_validRequest = (DLXTrainingRootsSvRQ) TestUtils.getXMLObject(filename, DLXTrainingRootsSvRQ.class);
    }

    /**
     * Returns the current project number.
     *
     * @return  the project number that is currently being tested
     */
    @Override
    protected String getProjectNumber()
    {
        return PROJECT_NUMBER;
    }

    /**
     * Test case for DLXTrainingRootsSvBean
     *
     * @see DLXTrainingRootsSvBean#processRequest(com.datalex.cbp.rqrs.CBPSvRQBase,
     *                                               com.datalex.matrix.handlers.base.BusinessHandler,
     *                                               com.datalex.mw.persistence.DBAccess)
     *
     * @throws Exception exception
     */
    @Test
    public void testReturnsValidRequest()
    {
        CBPSvRSBase result = m_dlxTrainingRootsSvBean.processRequest(m_emptyRequest, null, null);
        Assert.assertNotNull(result);
        if (!(result instanceof DLXTrainingRootsSvRS))
        {
            fail("result is not instance of DLXTrainingRootsSvRS");
        }
    }

    /**
     * Test case for DLXTrainingRootsSvBean
     *
     * @see DLXTrainingRootsSvBean#processRequest(com.datalex.cbp.rqrs.CBPSvRQBase,
     *                                               com.datalex.matrix.handlers.base.BusinessHandler,
     *                                               com.datalex.mw.persistence.DBAccess)
     *
     * @throws Exception exception
     */
    @Test
    public void testValidSegmentIfItPresentedInRequest()
    {
        int expectedSegmentNumber = m_validRequest.getResComponentSequenceNumber();
        Reservation reservation = m_validRequest.getReservation();
        DLXTrainingRootsSvRS result = (DLXTrainingRootsSvRS) m_dlxTrainingRootsSvBean.processRequest(m_validRequest, null, null);

        Set<Integer> expectedSegmentsLinks = new TreeSet<Integer>();
        for (ItinerarySegmentLink link : reservation.getResComponent(expectedSegmentNumber).getItinerarySegmentLink())
        {
            expectedSegmentsLinks.add(link.getSequence());
        }

        Set<Integer> resultSegments = new TreeSet<Integer>();
        for (ItinerarySegment segment : result.getItinerarySegment())
        {
            resultSegments.add(segment.getSequence());
        }

        try
        {
            Assert.assertEquals("Returned segment is not equal expected", expectedSegmentsLinks, resultSegments);
        }
        catch (IndexOutOfBoundsException e)
        {
            fail("requested segment number is not presented in request");
        }
    }
}
